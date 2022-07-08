package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PeriodoDAO {

    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS periodos (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tnumero INTEGER NOT NULL,\n" +
                    "\tcurso_id INTEGER NOT NULL,\n" +
                    "\n" +
                    "\tFOREIGN KEY(curso_id) REFERENCES cursos(id)\n" +
                    ");";


    private static final String TABLE_NAME = "periodos";
    private static final String ID_COLUMN = "id";
    private static final String NUMERO_COLUMN = "numero";
    private static final String CURSOS_COLUMN = "curso_id";

    private AppDB appDB;

    public PeriodoDAO(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean create(Periodo newPeriodo) {
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NUMERO_COLUMN, newPeriodo.getNumeroPeriodo());
            contentValues.put(CURSOS_COLUMN, newPeriodo.getCursoPeriodo().getId());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }

    @SuppressLint("Range")
    public Periodo getById(Periodo periodo) {
        Periodo result = null;
        CursoDAO cursoDAO = new CursoDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { periodo.getIdPeriodo() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                int numero = c.getInt(c.getColumnIndex(NUMERO_COLUMN));

                int cursoId = c.getInt(c.getColumnIndex(CURSOS_COLUMN));
                Curso curso = cursoDAO.getById(new Curso(cursoId));

                result = new Periodo(id,numero,curso);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public List<Periodo> getAll() {
        List<Periodo> periodos = new ArrayList<>();
        CursoDAO cursoDAO = new CursoDAO(this.appDB);

        SQLiteDatabase readDB = this.appDB.getReadableDatabase();

        try {
            Cursor c = readDB.query(TABLE_NAME, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                    int numero = c.getInt(c.getColumnIndex(NUMERO_COLUMN));

                    int cursoId = c.getInt(c.getColumnIndex(CURSOS_COLUMN));
                    Curso curso = cursoDAO.getById(new Curso(cursoId));

                    periodos.add(new Periodo(id, numero, curso));
                } while (c.moveToNext());
            }
        } catch(Exception e) {
            periodos = null;
        } finally {
            readDB.close();
        }
        return periodos;
    }

}

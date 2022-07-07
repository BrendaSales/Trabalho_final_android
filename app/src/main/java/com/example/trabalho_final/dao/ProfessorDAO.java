package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProfessorDAO {
    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS professores (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tnome TEXT NOT NULL,\n" + "\temail TEXT NOT NULL,\n" +
                    "\n" +
                    "\tFOREIGN KEY(materia_id) REFERENCES materias(id)\n" +
                    ");";


    private static final String TABLE_NAME = "professores";
    private static final String ID_COLUMN = "id";
    private static final String NOME_COLUMN = "nome";
    private static final String EMAIL_COLUMN = "email";
    private static final String MATERIA_COLUMN = "materia_id";

    private AppDB appDB;

    public ProfessorDAO(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean create(Professor newProfessor) {
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NOME_COLUMN, newProfessor.getNomeProfessor());
            contentValues.put(EMAIL_COLUMN, newProfessor.getEmail());
            contentValues.put(MATERIA_COLUMN, newProfessor.getMateriaProfessor().getIdMateria());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }

    @SuppressLint("Range")
    public Professor getById(Professor professor) {
        Professor result = null;
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { professor.getIdProfessor() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String name = c.getString(c.getColumnIndex(NOME_COLUMN));
                String email = c.getString(c.getColumnIndex(EMAIL_COLUMN));

                int materiaId = c.getInt(c.getColumnIndex(MATERIA_COLUMN));
                Materia materia = materiaDAO.getById(new Materia(materiaId));

                result = new Professor(id,name,materia,email);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

}

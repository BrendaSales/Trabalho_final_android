package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS materias (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tnome TEXT NOT NULL,\n" +
                    "\tcargaHoraria TEXT,\n"+
                    "\tsalaP TEXT,\n" +
                    "\tsalaT TEXT,\n"+
                    "\tperiodo_id INTEGER NOT NULL,\n" +
                    "\n" +
                    "\tFOREIGN KEY(periodo_id) REFERENCES periodos(id)\n" +
                    ");";


    private static final String TABLE_NAME = "materias";
    private static final String ID_COLUMN = "id";
    private static final String NOME_COLUMN = "nome";
    private static final String CARGAHORARIA_COLUMN = "cargaHoraria";
    private static final String SALAP_COLUMN = "salaP";
    private static final String SALAT_COLUMN = "salaT";
    private static final String PERIODO_COLUMN = "periodo_id";

    private AppDB appDB;

    public MateriaDAO(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean create(Materia newMateria) {
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NOME_COLUMN, newMateria.getNomeMateria());
            contentValues.put(CARGAHORARIA_COLUMN, newMateria.getCargaHoraria());
            contentValues.put(SALAP_COLUMN, newMateria.getSalaPratica());
            contentValues.put(SALAT_COLUMN, newMateria.getSalaTeorica());
            contentValues.put(PERIODO_COLUMN, newMateria.getPeriodoMateria().getIdPeriodo());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }

    @SuppressLint("Range")
    public Materia getById(Materia materia) {
        Materia result = null;
        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { materia.getIdMateria() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                String cargaHoraria = c.getString(c.getColumnIndex(CARGAHORARIA_COLUMN));
                String salaP = c.getString(c.getColumnIndex(SALAP_COLUMN));
                String salaT = c.getString(c.getColumnIndex(SALAT_COLUMN));

                int periodoId = c.getInt(c.getColumnIndex(PERIODO_COLUMN));
                Periodo periodo = periodoDAO.getById(new Periodo(periodoId));

                result = new Materia(id,nome,cargaHoraria,salaP,salaT,periodo);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public Materia getByName(Materia materia) {
        Materia result = null;
        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = NOME_COLUMN + "=?";
            String[] params = { materia.getNomeMateria() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                String cargaHoraria = c.getString(c.getColumnIndex(CARGAHORARIA_COLUMN));
                String salaP = c.getString(c.getColumnIndex(SALAP_COLUMN));
                String salaT = c.getString(c.getColumnIndex(SALAT_COLUMN));

                int periodoId = c.getInt(c.getColumnIndex(PERIODO_COLUMN));
                Periodo periodo = periodoDAO.getById(new Periodo(periodoId));

                result = new Materia(id,nome,cargaHoraria,salaP,salaT,periodo);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public List<Materia> getAll() {
        List<Materia> materias = new ArrayList<>();
        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        SQLiteDatabase readDB = this.appDB.getReadableDatabase();

        try {
            Cursor c = readDB.query(TABLE_NAME, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                    String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                    String cargaHoraria = c.getString(c.getColumnIndex(CARGAHORARIA_COLUMN));
                    String salaP = c.getString(c.getColumnIndex(SALAP_COLUMN));
                    String salaT = c.getString(c.getColumnIndex(SALAT_COLUMN));

                    int periodoId = c.getInt(c.getColumnIndex(PERIODO_COLUMN));
                    Periodo periodo = periodoDAO.getById(new Periodo(periodoId));

                    materias.add(new Materia(id, nome, cargaHoraria, salaP, salaT, periodo));
                } while (c.moveToNext());
            }
        } catch(Exception e) {
            materias = null;
        } finally {
            readDB.close();
        }
        return materias;
    }

}

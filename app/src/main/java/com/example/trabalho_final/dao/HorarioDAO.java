package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class HorarioDAO {
    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS horarios (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tdia TEXT NOT NULL,\n" +
                    "\thoraInicio TEXT NOT NULL,\n" +
                    "\thoraFim TEXT NOT NULL,\n" +
                    "\tmateria_id INTEGER NOT NULL,\n" +
                    "\n" +
                    "\tFOREIGN KEY(materia_id) REFERENCES materias(id)\n" +
                    ");";


    private static final String TABLE_NAME = "horarios";
    private static final String ID_COLUMN = "id";
    private static final String DIA_COLUMN = "dia";
    private static final String HORAI_COLUMN = "horaInicio";
    private static final String HORAF_COLUMN = "horaFim";
    private static final String MATERIA_COLUMN = "materia_id";

    private AppDB appDB;

    public HorarioDAO(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean create(Horario newHorario) {
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DIA_COLUMN, newHorario.getDia());
            contentValues.put(HORAI_COLUMN, newHorario.getHoraInicio());
            contentValues.put(HORAF_COLUMN, newHorario.getHoraFim());
            contentValues.put(MATERIA_COLUMN, newHorario.getMateriaHorario().getIdMateria());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }
    @SuppressLint("Range")
    public Horario getById(Horario horario) {
        Horario result = null;
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { horario.getIdHorario() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String dia = c.getString(c.getColumnIndex(DIA_COLUMN));
                String horaInicio = c.getString(c.getColumnIndex(HORAI_COLUMN));
                String horaFim = c.getString(c.getColumnIndex(HORAF_COLUMN));

                int materiaId = c.getInt(c.getColumnIndex(MATERIA_COLUMN));
                Materia materia = materiaDAO.getById(new Materia(materiaId));

                result = new Horario(id,dia,horaInicio,horaFim,materia);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public Horario getByDia(Horario horario) {
        Horario result = null;
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = DIA_COLUMN + "=?";
            String[] params = { horario.getDia() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String dia = c.getString(c.getColumnIndex(DIA_COLUMN));
                String horaInicio = c.getString(c.getColumnIndex(HORAI_COLUMN));
                String horaFim = c.getString(c.getColumnIndex(HORAF_COLUMN));

                int materiaId = c.getInt(c.getColumnIndex(MATERIA_COLUMN));
                Materia materia = materiaDAO.getById(new Materia(materiaId));

                result = new Horario(id,dia,horaInicio,horaFim,materia);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }


    @SuppressLint("Range")
    public List<Horario> getAll() {
        List<Horario> horarios = new ArrayList<>();
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        SQLiteDatabase readDB = this.appDB.getReadableDatabase();

        try {
            Cursor c = readDB.query(TABLE_NAME, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                    String dia = c.getString(c.getColumnIndex(DIA_COLUMN));
                    String horaInicio = c.getString(c.getColumnIndex(HORAI_COLUMN));
                    String horaFim = c.getString(c.getColumnIndex(HORAF_COLUMN));

                    int materiaId = c.getInt(c.getColumnIndex(MATERIA_COLUMN));
                    Materia materia = materiaDAO.getById(new Materia(materiaId));

                    horarios.add(new Horario(id, dia, horaInicio, horaFim, materia));
                } while (c.moveToNext());
            }
        } catch(Exception e) {
            horarios = null;
        } finally {
            readDB.close();
        }
        return horarios;
    }
}

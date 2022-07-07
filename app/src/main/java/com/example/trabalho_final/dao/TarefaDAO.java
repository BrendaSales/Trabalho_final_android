package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TarefaDAO {
    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS tarefas (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tnome TEXT NOT NULL,\n" + "\tdescricao TEXT NOT NULL,\n" +
                    "\n" +"\tdata TEXT NOT NULL,\n" +
                    "\tFOREIGN KEY(materia_id) REFERENCES materias(id)\n" +
                    ");";


    private static final String TABLE_NAME = "tarefas";
    private static final String ID_COLUMN = "id";
    private static final String NOME_COLUMN = "nome";
    private static final String DESCRICAO_COLUMN = "descricao";
    private static final String MATERIA_COLUMN = "materia_id";

    private AppDB appDB;

    public TarefaDAO(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean create(Tarefa newTarefa) {
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NOME_COLUMN, newTarefa.getNome());
            contentValues.put(DESCRICAO_COLUMN, newTarefa.getDescricaoTarefa());
            contentValues.put(MATERIA_COLUMN, newTarefa.getMateriaTarefa().getIdMateria());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }

    @SuppressLint("Range")
    public Tarefa getById(Tarefa tarefa) {
        Tarefa result = null;
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { tarefa.getIdTarefa() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                String descricao = c.getString(c.getColumnIndex(DESCRICAO_COLUMN));

                int materiaId = c.getInt(c.getColumnIndex(MATERIA_COLUMN));
                Materia materia = materiaDAO.getById(new Materia(materiaId));

                result = new Tarefa(id,nome,descricao,materia);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

}

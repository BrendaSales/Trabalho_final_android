package com.example.trabalho_final.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public static final String CREATE_SCRIPT =
            "CREATE TABLE IF NOT EXISTS usuarios (\n" +
                    "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\tnome TEXT NOT NULL,\n" +
                    "\temail TEXT NOT NULL UNIQUE\n"+
                    ");";

    private static final String TABLE_NAME = "usuarios";
    private static final String ID_COLUMN = "id";
    private static final String NOME_COLUMN = "nome";
    private static final String EMAIL_COLUMN = "email";

    private AppDB appDB;

    public UsuarioDAO(AppDB appDB){
        this.appDB = appDB;
    }

    public boolean create(Usuario newUser){
        boolean result = true;
        SQLiteDatabase writeDb = this.appDB.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(NOME_COLUMN, newUser.getNome());
            contentValues.put(EMAIL_COLUMN, newUser.getEmail());
            writeDb.insert(TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            result = false;
        } finally {
            writeDb.close();
        }

        return result;
    }

    @SuppressLint("Range")
    public Usuario getById(Usuario usuario) {
        Usuario result = null;
        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = ID_COLUMN + "=?";
            String[] params = { usuario.getId() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                String email = c.getString(c.getColumnIndex(EMAIL_COLUMN));

                result = new Usuario (id, nome, email);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public Usuario getByEmail(Usuario usuario) {
        Usuario result = null;

        SQLiteDatabase readDb = this.appDB.getReadableDatabase();

        try {
            String clause = EMAIL_COLUMN + "=?";
            String[] params = {usuario.getEmail() + "" };
            Cursor c = readDb.query(TABLE_NAME, null, clause, params, null, null, null, null);

            if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                String email = c.getString(c.getColumnIndex(EMAIL_COLUMN));


                result = new Usuario(id,nome,email);
            }
        } catch (Exception e) {
            result = null;
        } finally {
            readDb.close();
        }
        return result;
    }

    @SuppressLint("Range")
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase readDB = this.appDB.getReadableDatabase();

        try {
            Cursor c = readDB.query(TABLE_NAME, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(c.getColumnIndex(ID_COLUMN));
                    String nome = c.getString(c.getColumnIndex(NOME_COLUMN));
                    String email = c.getString(c.getColumnIndex(EMAIL_COLUMN));

                    usuarios.add(new Usuario(id, nome, email));
                } while (c.moveToNext());
            }
        } catch(Exception e) {
            usuarios = null;
        } finally {
            readDB.close();
        }
        return usuarios;
    }


}

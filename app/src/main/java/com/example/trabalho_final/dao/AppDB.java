package com.example.trabalho_final.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDB extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    public AppDB(Context context, String nome){
        super(context, nome, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDAO.CREATE_SCRIPT);
        db.execSQL(CursoDAO.CREATE_SCRIPT);
        db.execSQL(PeriodoDAO.CREATE_SCRIPT);
        db.execSQL(MateriaDAO.CREATE_SCRIPT);
        db.execSQL(ProfessorDAO.CREATE_SCRIPT);
        db.execSQL(HorarioDAO.CREATE_SCRIPT);
        db.execSQL(ProfessorDAO.CREATE_SCRIPT);
        db.execSQL(TarefaDAO.CREATE_SCRIPT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsuarioDAO.CREATE_SCRIPT);
        db.execSQL(CursoDAO.CREATE_SCRIPT);
        db.execSQL(PeriodoDAO.CREATE_SCRIPT);
        db.execSQL(MateriaDAO.CREATE_SCRIPT);
        db.execSQL(ProfessorDAO.CREATE_SCRIPT);
        db.execSQL(HorarioDAO.CREATE_SCRIPT);
        db.execSQL(ProfessorDAO.CREATE_SCRIPT);
        db.execSQL(TarefaDAO.CREATE_SCRIPT);
    }
}

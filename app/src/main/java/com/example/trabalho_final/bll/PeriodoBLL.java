package com.example.trabalho_final.bll;

import android.util.Log;

import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.CursoDAO;
import com.example.trabalho_final.dao.Periodo;
import com.example.trabalho_final.dao.PeriodoDAO;


import java.util.List;

public class PeriodoBLL {

    private AppDB appDB;

    public PeriodoBLL(AppDB appDB){
        this.appDB= appDB;
    }

    public boolean create(Integer numeroPeriodo, String nomeDoCurso) {
        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        CursoDAO cursoDAO = new CursoDAO(this.appDB);


        Curso curso = cursoDAO.getByName(new Curso(nomeDoCurso));
        if (curso == null) {
            Log.d("PERIODO", "Não conseguiu achar o curso pelo nome");
            return false;
        }


        Periodo novoPeriodo = new Periodo(numeroPeriodo, curso);

        if (!novoPeriodo.isValid()) {
            Log.d("PERIODO", "Periodo nao e valido");
            return false;
        }

        Periodo periodo = periodoDAO.getByNumero(novoPeriodo);
        if (periodo != null) {
            Log.d("PERIODO", "Já existe periodo com esse numero");
            return false;
        }

        boolean result = periodoDAO.create(novoPeriodo);
        return result;
    }

    public Periodo getPeriodo(Integer numeroPeriodo) {

        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        Periodo periodo = new Periodo(numeroPeriodo);

        return periodoDAO.getByNumero(periodo);
    }

    public List<Periodo> getAll() {
        List<Periodo> periodos;

        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        periodos = periodoDAO.getAll();

        return periodos;
    }
}

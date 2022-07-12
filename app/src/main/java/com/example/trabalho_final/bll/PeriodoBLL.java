package com.example.trabalho_final.bll;

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
            return  false;
        }

        Periodo novoPeriodo = new Periodo(numeroPeriodo);

        if (!novoPeriodo.isValid())
            return false;

        Periodo periodo = periodoDAO.getByNumero(novoPeriodo);
        if (curso != null)
            return false;

        boolean result = periodoDAO.create(novoPeriodo);
        return result;
    }

    public Curso getCurso(String nome) {

        CursoDAO cursoDAO = new CursoDAO(this.appDB);
        Curso curso = new Curso(nome);

        return cursoDAO.getByName(curso);
    }

    public List<Periodo> getAll() {
        List<Periodo> periodos;

        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        periodos = periodoDAO.getAll();

        return periodos;
    }
}

package com.example.trabalho_final.bll;

import android.util.Log;

import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.CursoDAO;
import com.example.trabalho_final.dao.Materia;
import com.example.trabalho_final.dao.MateriaDAO;
import com.example.trabalho_final.dao.Periodo;
import com.example.trabalho_final.dao.PeriodoDAO;

import java.util.List;

public class MateriaBLL {

    private AppDB appDB;

    public MateriaBLL(AppDB appDB){
        this.appDB= appDB;
    }

    public boolean create(String nomeDaMateria, Integer numeroDoPeriodo) {
        PeriodoDAO periodoDAO = new PeriodoDAO(this.appDB);
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);


        Periodo periodo = periodoDAO.getByNumero(new Periodo(numeroDoPeriodo));
        if (periodo == null) {
            Log.d("MATERIA", "Não conseguiu achar o periodo pelo numero");
            return false;
        }


        Materia novaMateria = new Materia(nomeDaMateria, periodo);

        if (!novaMateria.isValid()) {
            Log.d("MATERIA", "Materia nao e valida");
            return false;
        }

        Materia materia = materiaDAO.getByName(novaMateria);
        if (periodo != null) {
            Log.d("MATERIA", "Já existe materia com esse nome");
            return false;
        }

        boolean result = materiaDAO.create(novaMateria);
        return result;
    }

    public Materia getMateria(String nomeDaMateria) {

        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        Materia materia = new Materia(nomeDaMateria);

        return materiaDAO.getByName(materia);
    }

    public List<Materia> getAll() {
        List<Materia> materias;

        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);
        materias = materiaDAO.getAll();

        return materias;
    }
}

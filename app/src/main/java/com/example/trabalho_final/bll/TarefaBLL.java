package com.example.trabalho_final.bll;

import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Materia;
import com.example.trabalho_final.dao.MateriaDAO;
import com.example.trabalho_final.dao.Tarefa;
import com.example.trabalho_final.dao.TarefaDAO;

import java.util.List;

public class TarefaBLL {

    private AppDB appDB;

    public TarefaBLL(AppDB appDB){
        this.appDB= appDB;
    }

    public boolean create(String nome, String descricao, String data, String materiaNome) {
        TarefaDAO tarefaDAO = new TarefaDAO(this.appDB);
        MateriaDAO materiaDAO = new MateriaDAO(this.appDB);

        Materia materia = materiaDAO.getByName(new Materia(materiaNome));
        if (materia == null) {
            //ver como será o tratamento caso a materia não tenha sido cadastrada nesse caso ele cria a materia
           return  false;
        }

        Tarefa novaTarefa = new Tarefa(nome, descricao, data, materia);

        if (!novaTarefa.isValid())
            return false;

        Tarefa tarefa = tarefaDAO.getByName(novaTarefa);
        if (tarefa != null)
            return false;

        boolean result = tarefaDAO.create(novaTarefa);
        return result;
    }

    public List<Tarefa> getAll() {
        List<Tarefa> tasks;

        TarefaDAO tarefaDAO = new TarefaDAO(this.appDB);
        tasks = tarefaDAO.getAll();

        return tasks;
    }

}

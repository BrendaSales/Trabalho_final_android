package com.example.trabalho_final.bll;

import com.example.trabalho_final.dao.AppDB;
import com.example.trabalho_final.dao.Curso;
import com.example.trabalho_final.dao.CursoDAO;
import com.example.trabalho_final.dao.Usuario;
import com.example.trabalho_final.dao.UsuarioDAO;


import java.util.List;

public class CursoBLL {

    private AppDB appDB;

    public CursoBLL(AppDB appDB){
        this.appDB= appDB;
    }

    public boolean create(String nome, String email) {
        CursoDAO cursoDAO = new CursoDAO(this.appDB);
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.appDB);

        Usuario usuario = usuarioDAO.getByEmail(new Usuario(email));
        if (usuario == null) {
            return  false;
        }

        Curso novoCurso = new Curso(nome, usuario);

        if (!novoCurso.isValid())
            return false;

        Curso curso = cursoDAO.getByName(novoCurso);
        if (curso != null)
            return false;

        boolean result = cursoDAO.create(novoCurso);
        return result;
    }

    public Curso getCurso(String nome) {

        CursoDAO cursoDAO = new CursoDAO(this.appDB);
        Curso curso = new Curso(nome);

        return cursoDAO.getByName(curso);
    }

    public List<Curso> getAll() {
        List<Curso> cursos;

        CursoDAO cursoDAO = new CursoDAO(this.appDB);
        cursos = cursoDAO.getAll();

        return cursos;
    }
}

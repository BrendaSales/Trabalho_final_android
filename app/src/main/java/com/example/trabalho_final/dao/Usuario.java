package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String email;
    private List<Curso> cursoUsuario = new ArrayList<>();

    public Usuario(String nome, String email, Curso curso){
        this.nome = nome;
        this.email = email;
        cursoUsuario.add(curso);
    }

    public Usuario(Integer id,String nome, String email){
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;

    }

    public Usuario(int usuarioId) {
        this.idUsuario = usuarioId;
    }

    public Integer getId() {
        return idUsuario;
    }

    public void setId(Integer id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCurso() {
        return cursoUsuario;
    }

    public void setCurso(Curso curso) {
        this.cursoUsuario.add(curso);
    }
}

package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String email;
    private List<Curso> cursosUsuario;

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.cursosUsuario = new ArrayList<>();
    }

    public Usuario(Integer id,String nome, String email){
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.cursosUsuario = new ArrayList<>();

    }

    public void adicionarCurso(Curso curso) {

        this.cursosUsuario.add(curso);

    }

    public boolean isValid() {
        if (this.nome == null || this.nome.equals(""))
            return false;
        if (this.email == null || this.email.equals(""))
            return false;
        return true;
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

    public List<Curso> getCursosUsuario() {
        return cursosUsuario;
    }

    public void setCursosUsuario(Curso curso) {
        this.cursosUsuario.add(curso);
    }
}

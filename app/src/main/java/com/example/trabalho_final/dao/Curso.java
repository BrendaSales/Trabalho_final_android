package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private Integer idCurso;
    private String nomeCurso;
    private Usuario usuarioCurso;
    private List<Periodo> periodoCurso = new ArrayList<>();


    public Curso(String nome, Usuario usuario, Periodo periodo){
        this.nomeCurso = nome;
        this.usuarioCurso = usuario;
        periodoCurso.add(periodo);
    }

    public Curso(Integer idCurso,String nome, Usuario usuario){
        this.idCurso = idCurso;
        this.nomeCurso = nome;
        this.usuarioCurso = usuario;

    }
    public Curso(Integer idCurso){
        this.idCurso = idCurso;
    }


    public Integer getId() {
        return idCurso;
    }

    public void setId(Integer id) {
        this.idCurso = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Usuario getUsuarioId() {
        return usuarioCurso;
    }

    public void setUsuarioId(Usuario usuario) {
        this.usuarioCurso = usuario;
    }

    public List<Periodo> getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(Periodo periodoCurso) {
        this.periodoCurso.add(periodoCurso);
    }
}

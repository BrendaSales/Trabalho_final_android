package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private Integer idCurso;
    private String nomeCurso;
    private Usuario usuarioCurso;
    private List<Periodo> periodosCurso;


    public Curso(String nome, Usuario usuario){
        this.nomeCurso = nome;
        this.usuarioCurso = usuario;
        this.periodosCurso = new ArrayList<>();
    }

    public Curso(Integer idCurso,String nome, Usuario usuario){
        this.idCurso = idCurso;
        this.nomeCurso = nome;
        this.usuarioCurso = usuario;
        this.periodosCurso = new ArrayList<>();

    }
    public Curso(Integer idCurso){
        this.idCurso = idCurso;
    }

    public void adicionarPeriodos(Periodo periodo) {

        this.periodosCurso.add(periodo);

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

    public List<Periodo> getPeriodosCurso() {
        return periodosCurso;
    }

    public void setPeriodosCurso(Periodo periodoCurso) {
        this.periodosCurso.add(periodoCurso);
    }
}

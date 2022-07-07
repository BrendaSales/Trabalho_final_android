package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Periodo {
    private Integer idPeriodo;
    private String nomePeriodo;
    private Curso cursoPeriodo;
    private List<Materia> periodoMateria = new ArrayList<>();

    public Periodo (String nome,Curso curso, Materia materia){
        this.nomePeriodo = nome;
        this.cursoPeriodo = curso;
        this.periodoMateria.add(materia);
    }

    public Periodo (Integer idPeriodo,String nome,Curso curso){
        this.idPeriodo =idPeriodo;
        this.nomePeriodo = nome;
        this.cursoPeriodo = curso;
    }

    public Periodo (Integer idPeriodo){
        this.idPeriodo =idPeriodo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNomePeriodo() {
        return nomePeriodo;
    }

    public void setNomePeriodo(String nomePeriodo) {
        this.nomePeriodo = nomePeriodo;
    }

    public Curso getCursoPeriodo() {
        return cursoPeriodo;
    }

    public void setCursoPeriodo(Curso cursoPeriodo) {
        this.cursoPeriodo = cursoPeriodo;
    }

    public void setPeriodoMateria(Materia periodoMateria) {
        this.periodoMateria.add(periodoMateria);
    }

    public List<Materia> getPeriodoMateria() {
        return periodoMateria;
    }
}

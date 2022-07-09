package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Periodo {
    private Integer idPeriodo;
    private Integer numeroPeriodo;
    private Curso cursoPeriodo;
    private List<Materia> materiasPeriodo;

    public Periodo (Integer nome,Curso curso){
        this.numeroPeriodo = nome;
        this.cursoPeriodo = curso;
        this.materiasPeriodo = new ArrayList<>();
    }

    public Periodo (Integer idPeriodo,Integer numero,Curso curso){
        this.idPeriodo = idPeriodo;
        this.numeroPeriodo = numero;
        this.cursoPeriodo = curso;
    }

    public void adicionarMateria(Materia materia) {

        this.materiasPeriodo.add(materia);

    }

    public Periodo(Integer idPeriodo){
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getNumeroPeriodo() {
        return numeroPeriodo;
    }

    public void setNumeroPeriodo(Integer numeroPeriodo) {
        this.numeroPeriodo = numeroPeriodo;
    }

    public Curso getCursoPeriodo() {
        return cursoPeriodo;
    }

    public void setCursoPeriodo(Curso cursoPeriodo) {
        this.cursoPeriodo = cursoPeriodo;
    }

    public List<Materia> getMateriasPeriodo() {
        return materiasPeriodo;
    }

    public void setMateriasPeriodo(List<Materia> materiasPeriodo) {
        this.materiasPeriodo = materiasPeriodo;
    }

}

package com.example.trabalho_final.dao;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private Integer idMateria;
    private String nomeMateria;
    private String salaPratica;
    private String salaTeorica;
    private String cargaHoraria;
    private Periodo periodoMateria;
    private List<Professor> professorMateria = new ArrayList<>();



    public Materia (String nome, String salaPratica, String salaTeorica,
                 String cargaHoraria, Periodo periodo, Professor professorMateria){
        this.nomeMateria = nome;
        this.salaPratica = salaPratica;
        this.salaTeorica = salaTeorica;
        this.cargaHoraria =cargaHoraria;
        this.periodoMateria = periodo;
        this.professorMateria.add(professorMateria);
    }

    public Materia (Integer idMateria,String nome, String salaPratica, String salaTeorica,
                    String cargaHoraria, Periodo periodo){
        this.idMateria = idMateria;
        this.nomeMateria = nome;
        this.salaPratica = salaPratica;
        this.salaTeorica = salaTeorica;
        this.cargaHoraria =cargaHoraria;
        this.periodoMateria = periodo;
    }

    public Materia (int idMateria){
        this.idMateria=idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getSalaPratica() {
        return salaPratica;
    }

    public void setSalaPratica(String salaPratica) {
        this.salaPratica = salaPratica;
    }

    public String getSalaTeorica() {
        return salaTeorica;
    }

    public void setSalaTeorica(String salaTeorica) {
        this.salaTeorica = salaTeorica;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setPeriodoMateria(Periodo periodoMateria) {
        this.periodoMateria = periodoMateria;
    }

    public Periodo getPeriodoMateria() {
        return periodoMateria;
    }

    public List<Professor> getProfessorMateria() {
        return professorMateria;
    }

    public void setProfessorMateria(Professor professorMateria) {
        this.professorMateria.add(professorMateria);
    }
}


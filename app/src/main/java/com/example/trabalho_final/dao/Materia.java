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
    //private List<Professor> professoresMateria;
    private List<Tarefa> tarefasMateria;
    //private List<Horario> horariosMateria;


    public Materia(String nome, String salaPratica, String salaTeorica,
                   String cargaHoraria, Periodo periodo) {
        this.nomeMateria = nome;
        this.salaPratica = salaPratica;
        this.salaTeorica = salaTeorica;
        this.cargaHoraria = cargaHoraria;
        this.periodoMateria = periodo;
        //this.professoresMateria = new ArrayList<>();
        this.tarefasMateria = new ArrayList<>();
        //this.horariosMateria = new ArrayList<>();

    }

    public Materia(Integer idMateria, String nome, String salaPratica, String salaTeorica,
                   String cargaHoraria, Periodo periodo) {
        this.idMateria = idMateria;
        this.nomeMateria = nome;
        this.salaPratica = salaPratica;
        this.salaTeorica = salaTeorica;
        this.cargaHoraria = cargaHoraria;
        this.periodoMateria = periodo;
        //this.professoresMateria = new ArrayList<>();
        this.tarefasMateria = new ArrayList<>();
        //this.horariosMateria = new ArrayList<>();
    }

    public Materia(Integer idMateria, String nomeMateria){
        this.idMateria = idMateria;
        this.nomeMateria = nomeMateria;
    }

    public Materia(String nomeMateria, Periodo periodo){
        this.nomeMateria = nomeMateria;
        this.periodoMateria = periodo;
    }

    public Materia(String nomeMateria){
        this(null,nomeMateria);
    }

    public boolean isValid(){
        return nomeMateria !=null && !nomeMateria.equals("");
    }

    public Materia(int idMateria) {
        this.idMateria = idMateria;
    }

    //public void adicionarProfessor(Professor professor) {

//        this.professoresMateria.add(professor);
//
//    }

    public void adicionarTarefa(Tarefa tarefa) {

        this.tarefasMateria.add(tarefa);

    }

//    public void adicionarHorario(Horario horario) {
//
//        this.horariosMateria.add(horario);
//
//    }

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

//    public List<Professor> getProfessoresMateria() {
//        return professoresMateria;
//    }
//
//    public void setProfessoresMateria(List<Professor> professoresMateria) {
//        this.professoresMateria = professoresMateria;
//    }
    public List<Tarefa> getTarefasMateria() {
        return tarefasMateria;
    }

    public void setTarefasMateria(List<Tarefa> tarefasMateria) {
        this.tarefasMateria = tarefasMateria;
    }

//    public List<Horario> getHorariosMateria() {
//        return horariosMateria;
//    }
//
//    public void setHorariosMateria(List<Horario> horariosMateria) {
//        this.horariosMateria = horariosMateria;
//    }
}

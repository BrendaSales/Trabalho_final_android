package com.example.trabalho_final.dao;

public class Professor {

    private Integer idProfessor;
    private String nomeProfessor;
    private Materia materiaProfessor;
    private String email;

    public Professor (String nome, Materia materia, String email){
        this.nomeProfessor = nome;
        this.materiaProfessor = materia;
        this.email = email;
    }

    public Professor (Integer idProfessor, String nome, Materia materia, String email){
        this.idProfessor = idProfessor;
        this.nomeProfessor = nome;
        this.materiaProfessor = materia;
        this.email = email;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Materia getMateriaProfessor() {
        return materiaProfessor;
    }

    public void setMateriaProfessor(Materia materiaProfessor) {
        this.materiaProfessor = materiaProfessor;
    }
}

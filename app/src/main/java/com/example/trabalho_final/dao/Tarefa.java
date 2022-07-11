package com.example.trabalho_final.dao;

public class Tarefa {
    private Integer idTarefa;
    private String nome;
    private String descricaoTarefa;
    private String data;
    private Materia materiaTarefa;

    public Tarefa (String nome, String descricaoTarefa, String data, Materia materia){
        this.nome = nome;
        this.descricaoTarefa = descricaoTarefa;
        this.data = data;
        this.materiaTarefa = materia;
    }

    public Tarefa (Integer idTarefa, String nome, String descricaoTarefa, String data, Materia materia){
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.descricaoTarefa = descricaoTarefa;
        this.data = data;
        this.materiaTarefa = materia;
    }

    public boolean isValid(){
        if (this.nome == null || this.nome.equals(""))
            return false;
        if (this.descricaoTarefa == null || this.descricaoTarefa.equals(""))
            return false;
        if (!this.materiaTarefa.isValid())
            return false;
        return true;
    }

    public Materia getMateriaTarefa() {
        return materiaTarefa;
    }

    public void setMateriaTarefa(Materia materiaTarefa) {
        this.materiaTarefa = materiaTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }
}

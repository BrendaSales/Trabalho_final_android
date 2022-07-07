package com.example.trabalho_final.dao;

public class Horario {

    private Integer idHorario;
    private String dia;
    private String horaInicio;
    private String horaFim;
    private Materia materiaHorario;

    public Horario (String dia, String horaInicio, String horaFim, Materia materia){
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.materiaHorario = materia;
    }

    public Horario (Integer idHorario, String dia, String horaInicio, String horaFim, Materia materia){
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.materiaHorario = materia;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public void setMateriaHorario(Materia materiaHorario) {
        this.materiaHorario = materiaHorario;
    }

    public Materia getMateriaHorario() {
        return materiaHorario;
    }
}

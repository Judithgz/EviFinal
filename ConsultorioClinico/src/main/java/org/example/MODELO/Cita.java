package org.example.MODELO;

import java.time.LocalDateTime;

public class Cita {
    // Atributos
    private int id;
    private int idDoctor;
    private int idPaciente;
    private String fechaHora;
    private String motivo;

    // Constructor
    public Cita(int id, int idDoctor, int idPaciente, String motivo) {
        this.id = id;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.motivo = motivo;
        // Fecha y hora actual
        this.fechaHora = LocalDateTime.now().toString();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Métodos
    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"idDoctor\": " + idDoctor + ", \"idPaciente\": " + idPaciente
                + ", \"fechaHora\": \"" + fechaHora + "\", \"motivo\": \"" + motivo + "\"}";
    }
}

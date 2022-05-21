package org.example.MODELO;

public class Doctor {
    // Atributos 
    private int id;
    private String nombre;
    private String especialidad;

    // Constructor
    public Doctor(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Métodos
    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"nombre\": \"" + nombre + "\", \"especialidad\": \"" + especialidad + "\"}";
    }
}

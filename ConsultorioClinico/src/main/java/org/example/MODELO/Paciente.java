package org.example.MODELO;

public class Paciente {
    // Atributos
    private int id;
    private String nombre;
    
    // Constructor
    public Paciente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    // Métodos
    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"nombre\": \"" + nombre + "\"}";
    }
    
}

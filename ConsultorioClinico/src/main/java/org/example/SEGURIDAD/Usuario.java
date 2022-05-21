package org.example.SEGURIDAD;

import java.util.ArrayList;

public class Usuario {
    // Atributos
    private int id;
    private String nombre;
    private String usuario;
    private String password;
    private String rol;

    // Constructor
    public Usuario(int id, String nombre, String usuario, String password, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Métodos
    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"nombre\": \"" + nombre + "\", \"usuario\": \"" + usuario + "\", \"password\": \""
                + password + "\", \"rol\": \"" + rol + "\"}";
    }

    public boolean isValidUsuarioPassword(String usuario, String password) {
        return this.usuario.equals(usuario) && this.password.equals(password);
    }
}

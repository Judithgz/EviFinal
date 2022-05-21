package org.example.PERSISTENCIA;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.example.MODELO.Cita;
import org.example.MODELO.Doctor;
import org.example.MODELO.Paciente;
import org.example.SEGURIDAD.Usuario;
import org.example.VISTA.Vista;

public class Persistidor {
    // Todas las tablas de la base de datos se guardaran en ./db/
    private final static String ruta = "./db/";

    // Metodo que recibe un nombre de archivo y lo devuelve como un array de objetos
    // de tipo Usuario
    public static ArrayList<Usuario> leerArrayUsuarios() {
        try (FileReader reader = new FileReader(ruta + "usuarios" + ".json")) {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                usuarios.add(new Gson().fromJson(jsonArray.get(i), Usuario.class));
            }
            return usuarios;
        } catch (IOException e) {
            // Si no existe el archivo, devolvemos una lista vacia
            return new ArrayList<Usuario>();
        }
    }

    // Metodo que recibe un nombre de archivo y lo devuelve como un array de objetos
    // de tipo Doctor
    public static ArrayList<Doctor> leerArrayDoctores() {
        try (FileReader reader = new FileReader(ruta + "doctores" + ".json")) {
            ArrayList<Doctor> doctores = new ArrayList<Doctor>();
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                doctores.add(new Gson().fromJson(jsonArray.get(i), Doctor.class));
            }
            return doctores;
        } catch (IOException e) {
            // Si no existe el archivo, devolvemos una lista vacia
            return new ArrayList<Doctor>();
        }
    }

    // Metodo que recibe un nombre de archivo y lo devuelve como un array de objetos
    // de tipo Paciente
    public static ArrayList<Paciente> leerArrayPacientes() {
        try (FileReader reader = new FileReader(ruta + "pacientes" + ".json")) {
            ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                pacientes.add(new Gson().fromJson(jsonArray.get(i), Paciente.class));
            }
            return pacientes;
        } catch (IOException e) {
            // Si no existe el archivo, devolvemos una lista vacia
            return new ArrayList<Paciente>();
        }
    }

    // Metodo que recibe un nombre de archivo y lo devuelve como un array de objetos
    // de tipo Cita
    public static ArrayList<Cita> leerArrayCitas() {
        try (FileReader reader = new FileReader(ruta + "citas" + ".json")) {
            ArrayList<Cita> citas = new ArrayList<Cita>();
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                citas.add(new Gson().fromJson(jsonArray.get(i), Cita.class));
            }
            return citas;
        } catch (IOException e) {
            // Si no existe el archivo, devolvemos una lista vacia
            return new ArrayList<Cita>();
        }
    }

    // Metodo que recibe un array de objetos de tipo Usuario y lo guarda en un
    // archivo
    public static void guardarArrayUsuarios(ArrayList<Usuario> usuarios) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(ruta + "usuarios" + ".json");
            gson.toJson(usuarios, writer);
            writer.close();
        } catch (IOException e) {
            // Crear la carpeta ./db/ si no existe
            File writer = null;
            try {
                writer = new File(ruta);
                writer.mkdir();
            } catch (Exception e1) {
                Vista.imprimir("Error al crear la carpeta ./db/\n");
                Vista.imprimir("Error al guardar los datos de usuarios\n");
            }
        }
    }

    // Metodo que recibe un array de objetos de tipo Doctor y lo guarda en un
    // archivo
    public static void guardarArrayDoctores(ArrayList<Doctor> doctores) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(ruta + "doctores" + ".json");
            gson.toJson(doctores, writer);
            writer.close();
        } catch (IOException e) {
            // Crear la carpeta ./db/ si no existe
            File writer = null;
            try {
                writer = new File(ruta);
                writer.mkdir();
            } catch (Exception e1) {
                Vista.imprimir("Error al crear la carpeta ./db/\n");
                Vista.imprimir("Error al guardar los datos de doctores\n");
            }
        }
    }

    // Metodo que recibe un array de objetos de tipo Paciente y lo guarda en un
    // archivo
    public static void guardarArrayPacientes(ArrayList<Paciente> pacientes) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(ruta + "pacientes" + ".json");
            gson.toJson(pacientes, writer);
            writer.close();
        } catch (IOException e) {
            // Crear la carpeta ./db/ si no existe
            File writer = null;
            try {
                writer = new File(ruta);
                writer.mkdir();
            } catch (Exception e1) {
                Vista.imprimir("Error al crear la carpeta ./db/\n");
                Vista.imprimir("Error al guardar los datos de pacientes\n");
            }
        }
    }

    // Metodo que recibe un array de objetos de tipo Cita y lo guarda en un archivo
    public static void guardarArrayCitas(ArrayList<Cita> citas) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(ruta + "citas" + ".json");
            gson.toJson(citas, writer);
            writer.close();
        } catch (IOException e) {
            // Crear la carpeta ./db/ si no existe
            FileWriter writer = null;
            try {
                writer = new FileWriter(ruta);
                writer.close();
            } catch (IOException e1) {
                Vista.imprimir("Error al crear la carpeta ./db/\n");
                Vista.imprimir("Error al guardar los datos de citas\n");
            }
        }
    }

}
package org.example.CONTROLADOR;

import java.util.ArrayList;

import org.example.MODELO.Cita;
import org.example.MODELO.Doctor;
import org.example.MODELO.Paciente;
import org.example.PERSISTENCIA.Persistidor;
import org.example.SEGURIDAD.GestorUsuarios;
import org.example.VISTA.Vista;

public class Controlador {

    // Atributos
    private GestorUsuarios sesion;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Cita> listaCitas;

    // Constructor
    public Controlador() {
        sesion = new GestorUsuarios();
        listaDoctores = new ArrayList<Doctor>();
        listaPacientes = new ArrayList<Paciente>();
        listaCitas = new ArrayList<Cita>();

        // Cargamos los usuarios, doctores, pacientes y citas
        CargarDatos();

    }

    // Metodos
    private void CargarDatos() {
        listaDoctores = (ArrayList<Doctor>) Persistidor.leerArrayDoctores();
        listaPacientes = (ArrayList<Paciente>) Persistidor.leerArrayPacientes();
        listaCitas = (ArrayList<Cita>) Persistidor.leerArrayCitas();
    }

    private void GuardarDatos() {
        Persistidor.guardarArrayDoctores(listaDoctores);
        Persistidor.guardarArrayPacientes(listaPacientes);
        Persistidor.guardarArrayCitas(listaCitas);
    }

    // Mostrar menu
    int mostrarMenu(int opcion) {
        GuardarDatos();
        // 0: Menu principal
        // 1: Menu doctores
        // 2: Menu pacientes
        // 3: Menu citas
        // 4: Menu usuarios para usuarios
        // 5: Menu usuarios para administradores
        switch (opcion) {
            case 0:
                // 1. Iniciar sesion
                // 2. Registrar usuario
                // 0. Salir
                Vista.imprimir(". : : BIENVENIDO AL CONSULTORIO CLINICO : : .\n\n");
                Vista.imprimir("1. Iniciar sesion\n");
                Vista.imprimir("2. Registrar usuario\n");
                Vista.imprimir("0. Salir\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 2);

            case 1:
                // 1. Listar doctores
                // 2. Dar de alta doctor
                // 3. Dar de baja doctor
                // 4. Lstar doctores
                // 0. Volver
                Vista.imprimir("Menu doctores\n\n");
                Vista.imprimir("1. Listar doctores\n");
                Vista.imprimir("2. Dar de alta doctor\n");
                Vista.imprimir("3. Dar de baja doctor\n");
                Vista.imprimir("0. Volver\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 3);

            case 2:
                // 1. Listar pacientes
                // 2. Dar de alta paciente
                // 3. Dar de baja paciente
                // 4. Listar pacientes
                // 0. Volver
                Vista.imprimir("Menu pacientes\n\n");
                Vista.imprimir("1. Listar pacientes\n");
                Vista.imprimir("2. Dar de alta paciente\n");
                Vista.imprimir("3. Dar de baja paciente\n");
                Vista.imprimir("0. Volver\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 3);

            case 3:
                // 1. Listar citas
                // 2. Dar de alta cita
                // 3. Dar de baja cita
                // 4. Listar citas
                // 0. Volver
                Vista.imprimir("Menu citas\n\n");
                Vista.imprimir("1. Listar citas\n");
                Vista.imprimir("2. Dar de alta cita\n");
                Vista.imprimir("3. Dar de baja cita\n");
                Vista.imprimir("0. Volver\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 3);

            case 4:
                // 1. Listar usuarios
                // 0. Volver
                Vista.imprimir("Menu usuarios\n\n");
                Vista.imprimir("1. Listar usuarios\n");
                Vista.imprimir("0. Volver\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 1);

            case 5:
                // 1. Listar usuarios
                // 2. Dar de alta usuario
                // 3. Dar de baja usuario
                // 0. Volver

                Vista.imprimir("Menu administradores\n\n");
                Vista.imprimir("1. Listar usuarios\n");
                Vista.imprimir("2. Dar de alta un administrador\n");
                Vista.imprimir("3. Dar de baja usuario\n");
                Vista.imprimir("0. Volver\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 3);

            case 6:
                // Menu Principal
                // 1. Menu doctores
                // 2. Menu pacientes
                // 3. Menu citas
                // 4. Menu usuarios
                // 0. Salir
                Vista.imprimir("Menu principal\n\n");
                Vista.imprimir("1. Menu doctores\n");
                Vista.imprimir("2. Menu pacientes\n");
                Vista.imprimir("3. Menu citas\n");
                Vista.imprimir("4. Menu usuarios\n");
                Vista.imprimir("0. Cerrar Sesión\n");
                Vista.imprimir("> ");
                return Vista.entradaInt(0, 4);

            default:
                // Opcion no valida
                Vista.imprimir("Opcion no valida\n");
                return mostrarMenu(opcion);
        }

    }

    // Iniciar
    public void iniciar() {
        int opcion;
        do {

            // Mostramos el menú
            opcion = mostrarMenu(0); // Menu principal

            // Acciones
            switch (opcion) {
                case 1:
                    // Iniciar sesion
                    sesion.iniciarSesion();
                    break;
                case 2:
                    // Registrar usuario
                    sesion.registrar();
                    break;
                case 0:
                    // Salir
                    break;
            }

            if (sesion.isSesionActiva()) {
                int opcionPrincipal;
                do {
                    // Mostramos el menú
                    opcionPrincipal = mostrarMenu(6); // Menu principal

                    // Acciones
                    switch (opcionPrincipal) {
                        case 1:
                            // Menu doctores
                            int opcionDoctor;
                            do {
                                // Mostramos el menú
                                opcionDoctor = mostrarMenu(1); // Menu doctores

                                // Acciones
                                switch (opcionDoctor) {
                                    case 1:
                                        // Listar doctores
                                        listarDoctores();
                                        break;
                                    case 2:
                                        // Dar de alta doctor
                                        darDeAltaDoctor();
                                        break;
                                    case 3:
                                        // Dar de baja doctor
                                        darDeBajaDoctor();
                                        break;
                                    case 0:
                                        // Volver
                                        break;
                                }
                            } while (opcionDoctor != 0);
                            break;
                        case 2:
                            // Menu pacientes
                            int opcionPaciente;
                            do {
                                // Mostramos el menú
                                opcionPaciente = mostrarMenu(2); // Menu pacientes

                                // Acciones
                                switch (opcionPaciente) {
                                    case 1:
                                        // Listar pacientes
                                        listarPacientes();
                                        break;
                                    case 2:
                                        // Dar de alta paciente
                                        darDeAltaPaciente();
                                        break;
                                    case 3:
                                        // Dar de baja paciente
                                        darDeBajaPaciente();
                                        break;
                                    case 0:
                                        // Volver
                                        break;
                                }
                            } while (opcionPaciente != 0);
                            break;
                        case 3:
                            // Menu citas
                            int opcionCita;
                            do {
                                // Mostramos el menú
                                opcionCita = mostrarMenu(3); // Menu citas

                                // Acciones
                                switch (opcionCita) {
                                    case 1:
                                        // Listar citas
                                        listarCitas();
                                        break;
                                    case 2:
                                        // Dar de alta cita
                                        darDeAltaCita();
                                        break;
                                    case 3:
                                        // Dar de baja cita
                                        darDeBajaCita();
                                        break;
                                    case 0:
                                        // Volver
                                        break;
                                }
                            } while (opcionCita != 0);
                            break;
                        case 4:
                            // Menu usuarios
                            int opcionUsuario;
                            do {
                                // Mostramos el menú
                                if (sesion.isAdministrador()) {
                                    opcionUsuario = mostrarMenu(5); // Menu administradores

                                    switch (opcionUsuario) {
                                        case 1:
                                            // Listar usuarios
                                            listarUsuarios();
                                            break;
                                        case 2:
                                            // Dar de alta usuario
                                            darDeAltaUsuario();
                                            break;
                                        case 3:
                                            // Dar de baja usuario
                                            darDeBajaUsuario();
                                            break;
                                        case 0:
                                            // Volver
                                            break;
                                    }

                                } else {
                                    opcionUsuario = mostrarMenu(4); // Menu usuarios

                                    switch (opcionUsuario) {
                                        case 1:
                                            // Listar usuarios
                                            listarUsuarios();
                                            break;
                                        case 0:
                                            // Volver
                                            break;
                                    }

                                }
                            } while (opcionUsuario != 0);

                            break;

                        case 0:

                            // Cerrar sesión
                            sesion.cerrarSesion();
                            break;
                    }

                } while (opcionPrincipal != 0);

            }

        } while (opcion != 0);

        GuardarDatos();
    }

    private void darDeBajaUsuario() {
        sesion.darDeBajaUsuario();
    }

    private void darDeAltaUsuario() {
        sesion.crearAdministrador();
    }

    private void listarUsuarios() {
        sesion.listarUsuarios();
    }

    private void darDeBajaCita() {
        // Listar citas
        listarCitas();

        // Pedir el indice de la cita a dar de baja
        Vista.imprimir("Indice de la cita a dar de baja (-1 para cancelar): ");
        int indice = Vista.entradaInt(-1, listaCitas.size() - 1);
        // Dar de baja la cita
        if (indice != -1) {
            // Imprimir la cita
            Vista.imprimir(listaCitas.get(indice).toString()+"\n");
            // Preguntar si se quiere dar de baja
            Vista.imprimir("¿Desea dar de baja esta cita? (s/n): ");
            String respuesta = Vista.entradaString("sn");
            if (respuesta.equals("s")) {
                listaCitas.remove(indice);
                Vista.imprimir("Cita dada de baja correctamente\n");
            } else {
                Vista.imprimir("Cita no dada de baja\n");
            }
        }
    }

    private void darDeAltaCita() {
        // Pedir datos
        // Generar el id de la cita
        int idCita = generarIdCita();
        Vista.imprimir("Id de la cita: " + idCita + "\n");
        // Listar doctores
        listarDoctores();
        // Pedir el indice del doctor
        Vista.imprimir("Indice del doctor (-1 para cancelar): ");
        int indiceDoctor = Vista.entradaInt(-1, listaDoctores.size() - 1);
        if (indiceDoctor == -1) {
            Vista.imprimir("Cita no creada\n");
            return;
        }
        // Listar pacientes
        listarPacientes();
        // Pedir el indice del paciente
        Vista.imprimir("Indice del paciente (-1 para cancelar): ");
        int indicePaciente = Vista.entradaInt(-1, listaPacientes.size() - 1);
        if (indicePaciente == -1) {
            Vista.imprimir("Cita no creada");
            return;
        }
        // Pedir el motivo
        Vista.imprimir("Motivo de la cita: ");
        String motivo = Vista.entrada();
        // Crear cita
        Cita cita = new Cita(idCita, listaDoctores.get(indiceDoctor).getId(),
                listaPacientes.get(indicePaciente).getId(), motivo);
        // Añadir cita
        listaCitas.add(cita);
        // Imprimir cita
        Vista.imprimir("Cita creada correctamente\n" + cita.toString() + "\n");

    }

    private int generarIdCita() {
        int idCita = 0;
        for (Cita cita : listaCitas) {
            if (cita.getId() > idCita) {
                idCita = cita.getId();
            }
        }
        return idCita + 1;
    }

    private int generarIdPaciente() {
        int idPaciente = 0;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId() > idPaciente) {
                idPaciente = paciente.getId();
            }
        }
        return idPaciente + 1;
    }

    private int generarIdDoctor() {
        int idDoctor = 0;
        for (Doctor doctor : listaDoctores) {
            if (doctor.getId() > idDoctor) {
                idDoctor = doctor.getId();
            }
        }
        return idDoctor + 1;
    }

    private void listarCitas() {
        // Imprimir citas
        for (int i = 0; i < listaCitas.size(); i++) {
            Vista.imprimir((i) + ": " + listaCitas.get(i).toString() + "\n");
        }
    }

    private void darDeBajaPaciente() {
        // Listar pacientes
        listarPacientes();

        // Pedir el indice del paciente a dar de baja
        Vista.imprimir("Indice del paciente a dar de baja (-1 para cancelar): ");
        int indice = Vista.entradaInt(-1, listaPacientes.size() - 1);

        // Dar de baja el paciente
        if (indice != -1) {
            // Imprimir el paciente
            Vista.imprimir(listaPacientes.get(indice).toString()+"\n");
            // Preguntar si se quiere dar de baja
            Vista.imprimir("¿Desea dar de baja este paciente? (s/n): ");
            String respuesta = Vista.entradaString("sn");
            if (respuesta.equals("s")) {
                listaPacientes.remove(indice);
                Vista.imprimir("Paciente dado de baja correctamente\n");
            } else {
                Vista.imprimir("Paciente no dado de baja\n");
            }
        }

    }

    private void darDeAltaPaciente() {
        // Pedir datos
        // Generar el id del paciente
        int idPaciente = generarIdPaciente();
        Vista.imprimir("Id del paciente: " + idPaciente + "\n");
        // Pedir el nombre
        Vista.imprimir("Nombre del paciente: ");
        String nombre = Vista.entrada();
        // Crear paciente
        Paciente paciente = new Paciente(idPaciente, nombre);
        // Añadir paciente
        listaPacientes.add(paciente);
        // Imprimir paciente
        Vista.imprimir("Paciente creado correctamente\n" + paciente.toString() + "\n");
    }

    private void listarPacientes() {
        // Imprimir pacientes
        for (int i = 0; i < listaPacientes.size(); i++) {
            Vista.imprimir((i) + ": " + listaPacientes.get(i).toString() + "\n");
        }
    }

    private void listarDoctores() {
        // Imprimir doctores
        for (int i = 0; i < listaDoctores.size(); i++) {
            Vista.imprimir((i) + ": " + listaDoctores.get(i).toString() + "\n");
        }
    }

    private void darDeAltaDoctor() {
        // Pedir datos
        // Generar el id del doctor
        int idDoctor = generarIdDoctor();
        Vista.imprimir("Id del doctor: " + idDoctor + "\n");
        // Pedir el nombre
        Vista.imprimir("Nombre del doctor: ");
        String nombre = Vista.entrada();
        // Pedir la especialidad
        Vista.imprimir("Especialidad del doctor: ");
        String especialidad = Vista.entrada();
        // Crear doctor
        Doctor doctor = new Doctor(idDoctor, nombre, especialidad);
        // Añadir doctor
        listaDoctores.add(doctor);
        // Imprimir doctor
        Vista.imprimir("Doctor creado correctamente\n" + doctor.toString() + "\n");
    }

    private void darDeBajaDoctor() {
        // Listar doctores
        listarDoctores();

        // Pedir el indice del doctor a dar de baja
        Vista.imprimir("Indice del doctor a dar de baja (-1 para cancelar): ");
        int indice = Vista.entradaInt(-1, listaDoctores.size() - 1);

        // Dar de baja el doctor
        if (indice != -1) {
            // Imprimir el doctor
            Vista.imprimir(listaDoctores.get(indice).toString()+"\n");
            // Preguntar si se quiere dar de baja
            Vista.imprimir("¿Desea dar de baja este doctor? (s/n): ");
            String respuesta = Vista.entradaString("sn");
            if (respuesta.equals("s")) {
                listaDoctores.remove(indice);
                Vista.imprimir("Doctor dado de baja correctamente\n");
            } else {
                Vista.imprimir("Doctor no dado de baja\n");
            }
        }
    }

}
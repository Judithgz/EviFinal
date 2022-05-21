package org.example.SEGURIDAD;

import java.util.ArrayList;

import org.example.PERSISTENCIA.Persistidor;
import org.example.VISTA.Vista;

public class GestorUsuarios {
    // Atributos
    private ArrayList<Usuario> usuarios;
    // sesión actual
    private Usuario usuarioActual;

    // Constructor
    public GestorUsuarios() {

        usuarios = new ArrayList<Usuario>();

        // Cargamos los usuarios
        usuarios = (ArrayList<Usuario>) Persistidor.leerArrayUsuarios();

        // validar que usuarios no este vacio
        if (usuarios.isEmpty()) {
            // agregar administrador por defecto
            usuarios.add(new Usuario(0, "Super Usuario", "admin", encriptarPassword("admin"), "administrador"));
            // guardar los usuarios
            Persistidor.guardarArrayUsuarios(usuarios);
        }
    }

    // Métodos privados

    // Guarda los usuarios en un archivo JSON usando la libreria GSON
    private void guardarUsuarios() {
        Persistidor.guardarArrayUsuarios(usuarios);
    }

    // Generar id
    private int getId() {
        return usuarios.size() + 1;
    }

    // Pedir nombre
    private String pedirNombre() {
        Vista.imprimir("Ingrese su nombre: ");
        String nombre = Vista.entrada();
        while (nombre.isEmpty()) {
            Vista.imprimir("El nombre no puede estar vacio\n> ");
            nombre = Vista.entrada();
        }
        return nombre;
    }

    // Pedir usuario
    private String pedirUsuario() {
        Vista.imprimir("Ingrese su usuario: ");
        String usuario = Vista.entrada();
        while (usuario.isEmpty()) {
            Vista.imprimir("El usuario no puede estar vacio\n> ");
            usuario = Vista.entrada();
        }
        return usuario;
    }

    // Encripción de la contraseña
    private String encriptarPassword(String password) {
        String passwordEncriptado = "";
        int semilla = password.length();
        int pasos;
        for (int i = 0; i < password.length(); i++) {
            if (semilla > 'z' - 'A') {
                pasos = semilla - 'z' - 'A';
            } else {
                pasos = semilla;
            }
            passwordEncriptado += (char) (password.charAt(i) + pasos);
        }
        return passwordEncriptado;
    }

    // Pedir password
    private String pedirPassword() {
        Vista.imprimir("Ingrese su contraseña: ");
        String password = Vista.entrada();
        while (password.isEmpty()) {
            Vista.imprimir("El password no puede estar vacio\n> ");
            password = Vista.entrada();
        }
        return password;
    }

    // Saber si un usuario existe
    private boolean existeUsuario(String usuario) {
        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    // Métodos de autenticación y registro
    private boolean autenticar(String usuario, String password) {
        for (Usuario u : usuarios) {
            if (u.isValidUsuarioPassword(usuario, encriptarPassword(password))) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    public void registrar() {
        Vista.imprimir("Registro de usuario\n");
        int id = getId();
        String nombre = pedirNombre();
        String usuario = pedirUsuario();
        String password = pedirPassword();
        String rol = "usuario";
        if (existeUsuario(usuario)) {
            Vista.imprimir("El usuario ya existe\n");
        } else {
            usuarios.add(new Usuario(id, nombre, usuario, encriptarPassword(password), rol));
            Vista.imprimir("Usuario registrado\n");
        }
        guardarUsuarios();
    }

    // Métodos públicos
    public void iniciarSesion() {
        Vista.imprimir("Inicio de sesión\n");
        String usuario = pedirUsuario();
        String password = pedirPassword();
        if (autenticar(usuario, password)) {
            Vista.imprimir("Inicio de sesión correcto\n");
        } else {
            Vista.imprimir("Inicio de sesión incorrecto\n");
        }
        guardarUsuarios();
    }

    public void cerrarSesion() {
        Vista.imprimir("Cierre de sesión\n");
        usuarioActual = null;
    }

    public boolean isSesionActiva() {
        return usuarioActual != null;
    }

    public boolean isAdministrador() {
        return usuarioActual.getRol().equals("administrador");
    }

    // Metodos para administrar usuarios
    public void listarUsuarios() {
        Vista.imprimir("Listado de usuarios\n");
        for (Usuario usuario : usuarios) {
            Vista.imprimir(usuario.toString() + "\n");
        }
    }

    public void crearAdministrador() {
        if (isAdministrador()) {
            Vista.imprimir("Creación de administrador\n");
            int id = getId();
            String nombre = pedirNombre();
            String usuario = pedirUsuario();
            String password = pedirPassword();
            String rol = "administrador";
            if (existeUsuario(usuario)) {
                Vista.imprimir("El usuario ya existe\n");
            } else {
                usuarios.add(new Usuario(id, nombre, usuario, encriptarPassword(password), rol));
                Vista.imprimir("Administrador creado\n");
            }
            guardarUsuarios();
        } else {
            Vista.imprimir("No tiene permisos para crear administradores\n");
        }
    }

    public void darDeBajaUsuario() {
        if (isAdministrador()) {
            Vista.imprimir("Dar de baja usuario\n");
            String usuario = pedirUsuario();

            for (Usuario usuarioActual : usuarios) {
                if (usuarioActual.getUsuario().equals(usuario) && !usuarioActual.equals(this.usuarioActual)) {
                    usuarios.remove(usuarioActual);
                    Vista.imprimir("Usuario dado de baja\n");
                    break;
                }
            }
            guardarUsuarios();
        } else {
            Vista.imprimir("No tiene permisos para dar de baja usuarios\n");
        }
    }
}

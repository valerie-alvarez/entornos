package org.example.modelo;

public class Admin extends Usuario {

    // Constructor
    public Admin(String nombre, String correo, String contrasena, String tipoUsuario) {
        super(nombre, correo, contrasena, tipoUsuario); // Llama al constructor de Usuario
    }

    // Métodos específicos para Admin
    public void gestionarUsuarios() {
        System.out.println("Gestión de usuarios realizada.");
    }
}
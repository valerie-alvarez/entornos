package org.pruebasUsuario.modelo;

public class Admin extends Usuario {

    // Constructor
    public Admin(String nombre, String correo, String contrasena, String tipoUsuario) {
        super(nombre, correo, contrasena);
        this.setTipoUsuario("Admin");
    }

    // Métodos específicos para Admin
    public void gestionarUsuarios() {
        System.out.println("Gestión de usuarios realizada.");
    }
}
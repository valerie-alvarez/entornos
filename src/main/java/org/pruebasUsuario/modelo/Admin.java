package org.pruebasUsuario.modelo;

public class Admin extends Usuario {

    protected String nombre;
    protected String correo;
    protected String contrasena;
    protected String tipoUsuario;

    // Constructor
    public Admin(String nombre, String correo, String contrasena){
        super(nombre, correo, contrasena);
        this.setTipoUsuario("Admin");
    }

    // Métodos específicos para Admin
    public void gestionarUsuarios() {
        System.out.println("Gestión de usuarios realizada.");
    }
}
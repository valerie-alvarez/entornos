/*Clase que representa a un administrador, la cual extiende a la clase principal
Usuario. Los administradores tienen funcionalidades adicionales, 
como la gestión de usuarios. */

package org.pruebasUsuario.modelo;

public class Admin extends Usuario {

    protected String nombre;
    protected String correo;
    protected String contrasena;
    protected String tipoUsuario;

    public Admin(String nombre, String correo, String contrasena){
        super(nombre, correo, contrasena);
        this.setTipoUsuario("Admin");
    }

    public void gestionarUsuarios() {
        System.out.println("Gestión de usuarios realizada.");
    }
}

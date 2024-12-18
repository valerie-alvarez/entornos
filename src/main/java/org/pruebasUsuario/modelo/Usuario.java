/*Clase abstracta principal que representa a un usuario del sistema.
 Los usuarios tienen atributos en común y las subclases como Admin y Cliente 
 heredan de esta clase. */

package org.pruebasUsuario.modelo;

public abstract class Usuario {

    protected String nombre;
    protected String correo;
    protected String contrasena;
    protected String tipoUsuario;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = null;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (!this.contrasena.equals(contrasenaActual)) {
            throw new IllegalArgumentException("La contraseña actual es incorrecta.");
        }
        this.contrasena = nuevaContrasena;
    }
}

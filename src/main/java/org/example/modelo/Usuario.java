package org.example.modelo;

public abstract class Usuario {

    //Atributos
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipoUsuario;

    //Constructor
    public Usuario(String nombre, String correo, String contrasena, String tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
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

    //Metodo cambiar contraseña
    public void cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (!this.contrasena.equals(contrasenaActual)) {
            throw new IllegalArgumentException("La contraseña actual es incorrecta.");
        }
        this.contrasena = nuevaContrasena;
    }
}

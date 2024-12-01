package org.example.modelo;
import java.time.LocalDate;

public class Cliente extends Usuario{
    private LocalDate fechaNacimiento;
    private String telefono;
    private String numeroPasaporte;

    // Constructor
    public Cliente(String nombre, String correo, String contrasena, String tipoUsuario, LocalDate fechaNacimiento, String telefono, String numeroPasaporte) {
        super(nombre, correo, contrasena, tipoUsuario); // Llama al constructor de Usuario
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.numeroPasaporte = numeroPasaporte;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }
}

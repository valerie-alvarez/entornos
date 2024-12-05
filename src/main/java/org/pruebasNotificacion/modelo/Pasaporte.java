/* Clase que permite almacenar información de un pasaporte y 
proporciona métodos para acceder y modificar sus atributos.
Utiliza los métodos getter y setter para trabajar con sus atributos*/

package org.pruebasNotificacion.modelo;

import java.time.LocalDate;

public class Pasaporte {
    private String numero;
    private LocalDate fechaVencimiento;
    private String lugarExpedicion;
    private String correoCliente;

    public Pasaporte(String numero, LocalDate fechaVencimiento, String lugarExpedicion, String correoCliente) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.lugarExpedicion = lugarExpedicion;
        this.correoCliente = correoCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}

package org.pruebasSolicitud.modelo;

import java.time.LocalDate;

public class Cotizacion extends Solicitud {
    private String destino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double presupuesto;

    public Cotizacion(String clienteId, String destino, LocalDate fechaInicio, LocalDate fechaFin, double presupuesto) {
        super(clienteId); // Estado inicial es "Pendiente"
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.presupuesto = presupuesto;
        this.setEstado("Pendiente");
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}

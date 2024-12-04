package org.pruebasSolicitud.servicios;

import org.pruebasSolicitud.modelo.Cotizacion;
import org.pruebasSolicitud.modelo.repositorio.SolicitudRepositorio;

import java.time.LocalDate;


public class SolicitudServicio {
    private final SolicitudRepositorio solicitudRepositorio;

    //Constructor
    public SolicitudServicio(SolicitudRepositorio solicitudRepositorio) {
        this.solicitudRepositorio = solicitudRepositorio;
    }
    // Crear una solicitud de cotización
    public Cotizacion crearCotizacion(String clienteId, String destino,
                                      LocalDate fechaInicio, LocalDate fechaFin, double presupuesto) {
        validarCotizacion(destino, fechaInicio, fechaFin, presupuesto);

        Cotizacion cotizacion = new Cotizacion(clienteId, destino, fechaInicio, fechaFin, presupuesto);

        solicitudRepositorio.guardar(cotizacion); // Guardar en el repositorio (mock en pruebas)
        return cotizacion;
    }

    // Validar solicitud de cotización
    private void validarCotizacion(String destino, LocalDate fechaInicio, LocalDate fechaFin, double presupuesto) {
        if (destino == null || destino.isEmpty()) {
            throw new IllegalArgumentException("El destino no puede estar vacío.");
        }
        if (fechaInicio == null || fechaFin == null || fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("Las fechas ingresadas son inválidas.");
        }
        if (presupuesto <= 0) {
            throw new IllegalArgumentException("El presupuesto debe ser mayor que cero.");
        }
    }
}
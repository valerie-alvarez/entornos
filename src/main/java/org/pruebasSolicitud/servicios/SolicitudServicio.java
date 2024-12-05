/* Servicio encargado de gestionar las solicitudes, incluyendo la creación, validación 
y actualización de solicitudes como cotizaciones y visas. Trabaja en conjunto con el repositorio
para almacenar y buscar solicitudes. */

package org.pruebasSolicitud.servicios;

import org.pruebasSolicitud.modelo.Cotizacion;
import org.pruebasSolicitud.modelo.Solicitud;
import org.pruebasSolicitud.modelo.Visa;
import org.pruebasSolicitud.modelo.repositorio.SolicitudRepositorio;

import java.time.LocalDate;


public class SolicitudServicio {
    private final SolicitudRepositorio solicitudRepositorio;

    //Constructor
    public SolicitudServicio(SolicitudRepositorio solicitudRepositorio) {
        this.solicitudRepositorio = solicitudRepositorio;
    }

    // Crear una solicitud de cotización
    public Cotizacion crearCotizacion(Cotizacion cotizacion) {
        ;
        solicitudRepositorio.guardar(cotizacion);
        return solicitudRepositorio.buscarporId(cotizacion.getId());
    }

    public Visa crearVisa(Visa visa) {
        validarVisa(visa);
        solicitudRepositorio.guardar(visa);
        return solicitudRepositorio.buscarporId(visa.getId());
    }

    private void validarVisa(Visa visa) {
        if (visa.getTipoVisa() == null || visa.getTipoVisa().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de visa.");
        }
    }

    public String verificarEstadoSolicitud(Solicitud solicitud) {
        return solicitudRepositorio.buscarporId(solicitud.getId()).getEstado();
    }

    public void actualizarEstado(String id, String nuevoEstado) {
        Cotizacion cotizacion = solicitudRepositorio.buscarporId(id);
        if (cotizacion != null) {
            cotizacion.setEstado(nuevoEstado);
        }
        else{throw new IllegalArgumentException("Solicitud no encontrada");}
    }
}

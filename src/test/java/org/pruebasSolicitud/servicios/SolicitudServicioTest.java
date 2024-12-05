package org.pruebasSolicitud.servicios;
import org.junit.Test;
import org.mockito.Mockito;
import org.pruebasSolicitud.modelo.Cotizacion;
import org.pruebasSolicitud.modelo.Visa;
import org.pruebasSolicitud.modelo.Solicitud;
import org.pruebasSolicitud.modelo.repositorio.SolicitudRepositorio;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SolicitudServicioTest {

    @Test
    public void cotizacionExitosa(){
        SolicitudRepositorio solicitudRepositorio = Mockito.mock(SolicitudRepositorio.class);

        Cotizacion cotizacionEntrada = new Cotizacion(
                "1", "natalia@ejemplo.com", "Lima", LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 30), 3000000.0);

        Cotizacion cotizacionEsperada = new Cotizacion(
                "1", "natalia@ejemplo.com", "Lima", LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 30), 3000000.0);

        SolicitudServicio solicitudServicio = new SolicitudServicio(solicitudRepositorio);

        Mockito.when(solicitudRepositorio.buscarporId(cotizacionEntrada.getId()))
                .thenReturn(cotizacionEsperada);

        Cotizacion cotizacionResultado = solicitudServicio.crearCotizacion(cotizacionEntrada);

        assertEquals(cotizacionResultado, cotizacionEsperada);

    }

    @Test
    public void visa_datosIncompletos(){
        SolicitudRepositorio solicitudRepositorio = Mockito.mock(SolicitudRepositorio.class);
        SolicitudServicio solicitudServicio = new SolicitudServicio(solicitudRepositorio);

        Visa visaEntrada = new Visa( "1",
                "natalia@example.com",
                null,
                "A12345678",
                "Colombia");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            solicitudServicio.crearVisa(visaEntrada);
        });

        assertEquals("Debe seleccionar un tipo de visa.", exception.getMessage());
    }

    @Test
    public void verificarEstadoSolicitud() {

        SolicitudRepositorio solicitudRepositorio = Mockito.mock(SolicitudRepositorio.class);
        Solicitud solicitud = new Cotizacion(
                "1", "natalia@ejemplo.com", "Lima", LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 30), 3000000.0);
        when(solicitudRepositorio.buscarporId("1")).thenReturn(solicitud);

        String estadoEsperado = "Pendiente";


        SolicitudServicio solicitudServicio = new SolicitudServicio(solicitudRepositorio);


        String estado = solicitudServicio.verificarEstadoSolicitud(solicitud);

        assertEquals(estadoEsperado, estado);
    }
}
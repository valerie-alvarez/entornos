package org.pruebasSolicitud.servicios;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.pruebasSolicitud.modelo.Cotizacion;
import org.pruebasSolicitud.modelo.repositorio.SolicitudRepositorio;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SolicitudServicioTest {

    @Test
    public void cotizacionExitosa(){
        SolicitudRepositorio mockRepositorio = Mockito.mock(SolicitudRepositorio.class);

        SolicitudServicio solicitudServicio = new SolicitudServicio(mockRepositorio);

        Cotizacion nuevaCotizacion = solicitudServicio.crearCotizacion(
                "natalia@ejemplo.com",
                "Lima",
                LocalDate.of(2024, 6, 15),
                LocalDate.of(2024, 6, 30),
                3000000.0
        );

        assertNotNull(nuevaCotizacion);
        assertEquals("Lima", nuevaCotizacion.getDestino());
        assertEquals(3000000.0, nuevaCotizacion.getPresupuesto());
        assertEquals("natalia@ejemplo.com", nuevaCotizacion.getClienteId());

        verify(mockRepositorio, times(1)).guardar(nuevaCotizacion);
    }

    @Test
    public void cotizacion_datosIncompletos(){

    }
}
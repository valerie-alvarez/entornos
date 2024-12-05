package org.pruebasNotificacion;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pruebasNotificacion.modelo.NotificacionAPI;
import org.pruebasNotificacion.modelo.Pasaporte;
import org.pruebasNotificacion.servicios.NotificacionServicio;
import org.pruebasSolicitud.modelo.Cotizacion;
import org.pruebasSolicitud.modelo.Solicitud;
import org.pruebasSolicitud.modelo.Visa;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class NotificacionServicioTest {

    @Test
    public void notificarVencimientoPasaporte() {
        NotificacionAPI notificacionAPI = Mockito.mock(NotificacionAPI.class);
        NotificacionServicio notificacionServicio = new NotificacionServicio(notificacionAPI);

        Pasaporte pasaporteEntrada = new Pasaporte("A12345678", LocalDate.now().plusDays(90), "Risaralda", "natalia@example.com");

        when(notificacionAPI.enviarCorreo("natalia@example.com", "¡Atención!",
                "Tu pasaporte vence en 90 días.")
        ).thenReturn(true);

        boolean notificacionResultado = notificacionServicio.notificarVencimientoPasaporte(pasaporteEntrada);

        assertTrue(notificacionResultado);
    }

    @Test
    public void notificarCambioEstado() {
        NotificacionAPI notificacionAPI = Mockito.mock(NotificacionAPI.class);

        Solicitud solicitudInicial = new Visa( "1",
                "natalia@example.com",
                "China",
                "A12345678",
                "Colombia");

        String estadoInicial = solicitudInicial.getEstado(); //El estado aquí es "Pendiente"
        String estadoEsperado = "En revisión";

        Mockito.when(notificacionAPI.enviarCorreo(solicitudInicial.getClienteId(), "Atención!",
                        "Tu pasaporte va a vencer!")).thenReturn(true);

        NotificacionServicio notificacionServicio = new NotificacionServicio(notificacionAPI);

        Solicitud resultado = notificacionServicio.cambiarEstado(solicitudInicial, "En revisión");

        assertEquals(resultado.getEstado(), estadoEsperado);
    }
}
package org.pruebasNotificacion;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pruebasNotificacion.modelo.NotificacionAPI;
import org.pruebasNotificacion.modelo.Pasaporte;
import org.pruebasNotificacion.servicios.NotificacionServicio;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

public class NotificacionServicioTest {

    @Test
    public void notificarVencimientoPasaporte() {
        NotificacionAPI notificacionAPI = Mockito.mock(NotificacionAPI.class);
        NotificacionServicio notificacionServicio = new NotificacionServicio(notificacionAPI);

        Pasaporte pasaporteEntrada = new Pasaporte("A12345678", LocalDate.now().plusDays(90), "Risaralda", "natalia@example.com");

        Mockito.when(notificacionAPI.enviarCorreo("natalia@example.com", "¡Atención!",
                "Tu pasaporte vence en 90 días.")
        ).thenReturn(true);

        boolean notificacionResultado = notificacionServicio.notificarVencimientoPasaporte(pasaporteEntrada);

        assertTrue(notificacionResultado);
    }
}
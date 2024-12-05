package org.pruebasNotificacion.servicios;

import org.pruebasNotificacion.modelo.NotificacionAPI;
import org.pruebasNotificacion.modelo.Pasaporte;

import java.time.LocalDate;

public class NotificacionServicio {
    private final NotificacionAPI notificacionAPI;

    public NotificacionServicio(NotificacionAPI notificacionAPI) {
        this.notificacionAPI = notificacionAPI;
    }

    public boolean notificarVencimientoPasaporte(Pasaporte pasaporte) {
        LocalDate hoy = LocalDate.now();
        long diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(hoy, pasaporte.getFechaVencimiento());

        if (diasRestantes == 90 || diasRestantes == 60 || diasRestantes == 30) {
            return notificacionAPI.enviarCorreo(pasaporte.getCorreoCliente(), "¡Atención!",
                    "Tu pasaporte vence en " + diasRestantes + " días.");
        }
        else return false;
    }

    /**simula envío de notificaciones
    private void enviarNotificacion(String clienteId, String mensaje) {
        //simula envío de una notificación
        System.out.println("Notificación enviada a " + clienteId + ": " + mensaje);
    }*/
}

package org.pruebasNotificacion.servicios;

import org.pruebasNotificacion.modelo.NotificacionAPI;
import org.pruebasNotificacion.modelo.Pasaporte;
import org.pruebasSolicitud.modelo.Solicitud;

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

    public <T extends Solicitud> T cambiarEstado(Solicitud solicitud, String nuevoEstado) {
        solicitud.setEstado(nuevoEstado);
        notificarCambioEstado(solicitud);
        return (T) solicitud;
    }

    public boolean notificarCambioEstado(Solicitud solicitud) {
        String correoCliente = solicitud.getClienteId();
        String asunto = "Estado actualizado de tu solicitud";
        String mensaje = "El estado de tu solicitud ha cambiado. Por favor, revisa el portal para más detalles.";

        return notificacionAPI.enviarCorreo(correoCliente, asunto, mensaje);
    }
}

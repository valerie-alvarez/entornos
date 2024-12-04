package org.pruebasSolicitud.modelo.repositorio;
import org.pruebasSolicitud.modelo.Solicitud;
import java.util.HashMap;
import java.util.Map;

public class SolicitudRepositorio {
    private final Map<String, Solicitud> solicitudes = new HashMap<>();

    public void guardar(Solicitud solicitud) {
        solicitudes.put(solicitud.getClienteId(), solicitud);
    }

    public Solicitud buscarPorId(String id) {
        return solicitudes.get(id);
    }

    public void actualizarEstado(String id, String nuevoEstado) {
        Solicitud solicitud = solicitudes.get(id);
        if (solicitud != null) {
            solicitud.setEstado(nuevoEstado);
        }
    }
}

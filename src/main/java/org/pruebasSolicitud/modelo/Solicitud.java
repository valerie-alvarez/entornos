/*Clase abstracta que representa una solicitud realizada por un cliente.
 Contiene atributos comunes a todas las solicitudes. */

package org.pruebasSolicitud.modelo;

public abstract class Solicitud {

    protected String id;
    protected String clienteId; // Cliente que realiza la solicitud
    protected String estado;

    //Constructor
    public Solicitud(String id, String clienteId) {
        this.id = id;
        this.clienteId = clienteId;
        this.estado = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

package org.pruebasSolicitud.modelo;

public abstract class Solicitud {
    //Atributos
    protected String clienteId; // Cliente que realiza la solicitud
    protected String estado;

    //Constructor
    public Solicitud(String clienteId) {
        this.clienteId = clienteId;
        this.estado = null;
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
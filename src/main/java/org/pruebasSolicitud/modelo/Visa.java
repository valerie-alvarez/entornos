package org.pruebasSolicitud.modelo;

public class Visa extends Solicitud {
    private String tipoVisa;
    private String numeroPasaporte;
    private String nacionalidad;

    public Visa(String tipoVisa, String numeroPasaporte, String nacionalidad) {
        super(clienteId); // Estado inicial es "Pendiente"
        this.tipoVisa = tipoVisa;
        this.numeroPasaporte = numeroPasaporte;
        this.nacionalidad = nacionalidad;
        this.setEstado("Pendiente");
    }

    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}

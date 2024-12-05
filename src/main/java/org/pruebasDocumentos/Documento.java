package org.pruebasDocumentos;

public class Documento {
    private String url;
    private Long size;
    private String formato;

    Documento(String url, Long size, String formato){
        this.url = url;
        this.size = size;
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}

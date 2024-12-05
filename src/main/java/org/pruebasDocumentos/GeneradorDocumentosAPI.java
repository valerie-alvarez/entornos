package org.pruebasDocumentos;

import javax.print.Doc;

public class GeneradorDocumentosAPI {
    public void generar(Documento documento){return;}

    public Documento generarDocumento(Documento documento) {
        documento.setUrl("http://url.com/");
        return documento;
    }
}

package org.pruebasDocumentos;

import javax.print.Doc;

/*Proporciona funcionalidades como cargar documentos en el repositorio, validar 
atributos de los documentos, y generar nuevos documentos utilizando una API.*/

public class DocumentoServicio {
    private final GeneradorDocumentosAPI generadorDocumentosAPI;
    private final DocumentoRepositorio documentoRepositorio;

    DocumentoServicio(GeneradorDocumentosAPI generadorDocumentosAPI, DocumentoRepositorio documentoRepositorio){
        this.generadorDocumentosAPI = generadorDocumentosAPI;
        this.documentoRepositorio = documentoRepositorio;
    }
    public boolean cargarDocumento(Documento documento){
        //Lógica para válidar y guardar el documento
        if (validarSize(documento.getSize())==false) {
            return false; //Tamaño demasiado grande
        }

        if (validarFormato(documento.getFormato())==false) {
            return false; //Formato no válido
        }

        return documentoRepositorio.guardar(documento);
    }

    private boolean validarFormato(String formato) {
            if (formato == "pdf") return true;
            else return false;
    }

    private boolean validarSize(Long size) {
        final long sizeMax = 1024; 
        return size <= sizeMax;
    }

    //Genera un nuevo documento utilizando la API.
    public Documento generarDocumento(Documento documento) {
        Documento documentoGenerado = generadorDocumentosAPI.generarDocumento(documento);

        if (documentoGenerado != null) {
            return documentoGenerado;
        } else {
            return null;
        }
    }

}

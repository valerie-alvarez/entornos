package org.pruebasDocumentos;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import javax.print.Doc;

@ExtendWith(MockitoExtension.class)
public class DocumentoServicioTest {

//Prueba unitaria del requerimiento funcional número nueve.
    @Test
    public void cargarDocumentoExitoso() {

        GeneradorDocumentosAPI generadorDocumentosAPI = Mockito.mock(GeneradorDocumentosAPI.class);
        DocumentoRepositorio documentoRepositorio = Mockito.mock(DocumentoRepositorio.class);

        DocumentoServicio documentosServicio = new DocumentoServicio(generadorDocumentosAPI, documentoRepositorio);

        Documento documentoEntrada = new Documento("pasaporte.pdf", 1024L, "pdf");

        Mockito.when(documentoRepositorio.guardar(documentoEntrada)).thenReturn(true);

        boolean resultado = documentosServicio.cargarDocumento(documentoEntrada);

        assertTrue(resultado, "El documento debe cargarse correctamente.");

    }

@Test
public void documentoDemasiadoGrande() {

    GeneradorDocumentosAPI generadorDocumentosAPI = Mockito.mock(GeneradorDocumentosAPI.class);
    DocumentoRepositorio documentoRepositorio = Mockito.mock(DocumentoRepositorio.class);

    DocumentoServicio documentosServicio = new DocumentoServicio(generadorDocumentosAPI, documentoRepositorio);

    Documento documentoGrande = new Documento("entornos.pdf", 2048L, "pdf");

    boolean resultado = documentosServicio.cargarDocumento(documentoGrande);

    assertFalse(resultado);
    }


    @Test
    public void documentoFormatoIncorrecto() {

        GeneradorDocumentosAPI generadorDocumentosAPI = Mockito.mock(GeneradorDocumentosAPI.class);
        DocumentoRepositorio documentoRepositorio = Mockito.mock(DocumentoRepositorio.class);

        DocumentoServicio documentosServicio = new DocumentoServicio(generadorDocumentosAPI, documentoRepositorio);

        Documento documentoInvalido = new Documento("archivo.exe", 1024L, "exe");

        boolean resultado = documentosServicio.cargarDocumento(documentoInvalido);

        assertFalse(resultado);
    }

    @Test
    public void generarDocumentoExitoso() {

        Documento documento = new Documento(null, 1024L, "form");
        Documento documentoGenerado = new Documento("https//:formulario.pdf", 1024L, "form");

        GeneradorDocumentosAPI generadorDocumentosAPI = Mockito.mock(GeneradorDocumentosAPI.class);
        DocumentoRepositorio documentoRepositorio = Mockito.mock(DocumentoRepositorio.class);

        Mockito.when(generadorDocumentosAPI.generarDocumento(documento)).thenReturn(documentoGenerado);

        DocumentoServicio documentoServicio = new DocumentoServicio(generadorDocumentosAPI, documentoRepositorio);

        Documento resultado = documentoServicio.generarDocumento(documento);

       assertEquals("https//:formulario.pdf",resultado.getUrl());
    }

    @Test
    public void generarDocumento_Fallo() {
        Documento documento = new Documento(null, 1024L, "form");

        GeneradorDocumentosAPI generadorDocumentosAPI = Mockito.mock(GeneradorDocumentosAPI.class);
        DocumentoRepositorio documentoRepositorio = Mockito.mock(DocumentoRepositorio.class);

        Mockito.when(generadorDocumentosAPI.generarDocumento(documento)).thenReturn(null);

        DocumentoServicio documentoServicio = new DocumentoServicio(generadorDocumentosAPI, documentoRepositorio);

        Documento documentoGenerado = documentoServicio.generarDocumento(documento);

        assertNull(documentoGenerado, "Error al generar su documento");
    }

}

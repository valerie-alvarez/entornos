package org.example.servicios;
import org.example.modelo.Usuario;
import org.example.modelo.repositorio.UsuarioRepositorio;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServicioTest {
    @Test
    public void registro_Exitoso(){
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);
        when(mockRepositorio.buscarporCorreo("prueba@ejemplo.com")).thenReturn(null);

        UsuarioServicio usuarioServicio = new UsuarioServicio(mockRepositorio);

        Usuario nuevoCliente = usuarioServicio.registrarCliente("Natalia Álvarez","natalia@ejemplo.com", "123", LocalDate.now(), "313333333", "AB0E43");

        assertNotNull(nuevoCliente);
        assertEquals("Natalia Álvarez", nuevoCliente.getNombre());
        assertEquals("natalia@ejemplo.com", nuevoCliente.getCorreo());
        verify(mockRepositorio, times(1)).guardar(nuevoCliente);
    }

    @Test
    public void correoDuplicado(){

    }
}


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
    public void registro_Exitoso() {
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);
        when(mockRepositorio.buscarporCorreo("prueba@ejemplo.com")).thenReturn(null);

        UsuarioServicio usuarioServicio = new UsuarioServicio(mockRepositorio);

        Usuario nuevoCliente = usuarioServicio.registrarCliente("Natalia Álvarez", "natalia@ejemplo.com", "123", LocalDate.now(), "313333333", "AB0E43");

        assertNotNull(nuevoCliente);
        assertEquals("Natalia Álvarez", nuevoCliente.getNombre());
        assertEquals("natalia@ejemplo.com", nuevoCliente.getCorreo());
        verify(mockRepositorio, times(1)).guardar(nuevoCliente);
    }

    @Test
    public void correoDuplicado() {
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);
        when(mockRepositorio.buscarporCorreo("natalia@ejemplo.com")).thenReturn(new Usuario("Natalia Álvarez", "natalia@ejemplo.com", "123", "Cliente") {});

        UsuarioServicio usuarioServicio = new UsuarioServicio(mockRepositorio);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioServicio.registrarCliente("Natalia Álvarez", "natalia@ejemplo.com", "123", LocalDate.now(), "313333333", "AB0E43");
        });

        assertEquals("El correo ya está registrado", exception.getMessage());
        verify(mockRepositorio, times(1)).buscarporCorreo("natalia@ejemplo.com");
    }

    @Test
    public void iniciarSesion_Exito() {
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Usuario usuarioMock = new Usuario("Natalia Álvarez", "natalia@ejemplo.com", "123", "Cliente") {};

        when(mockRepositorio.buscarporCorreoyContrasena("natalia@ejemplo.com", "123")).thenReturn(usuarioMock);

        UsuarioServicio usuarioServicio = new UsuarioServicio(mockRepositorio);
        Usuario usuarioResultado = usuarioServicio.iniciarSesion("natalia@ejemplo.com", "123");

        assertNotNull(usuarioResultado);
        assertEquals("Natalia Álvarez", usuarioResultado.getNombre());
        assertEquals("natalia@ejemplo.com", usuarioResultado.getCorreo());
        verify(mockRepositorio, times(1)).buscarporCorreoyContrasena("natalia@ejemplo.com", "123");
    }

    @Test
    public void iniciarSesion_DatosIncorrectos() {
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);

        when(mockRepositorio.buscarporCorreoyContrasena("natalia@ejemplo.com", "incorrecta")).thenReturn(null);
        UsuarioServicio usuarioServicio = new UsuarioServicio(mockRepositorio);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioServicio.iniciarSesion("natalia@ejemplo.com", "incorrecta");
        });

        assertEquals("Datos incorrectos", exception.getMessage());
        verify(mockRepositorio, times(1)).buscarporCorreoyContrasena("natalia@ejemplo.com", "incorrecta");
    }
}

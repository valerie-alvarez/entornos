package org.pruebasUsuario.servicios;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;
import org.pruebasUsuario.modelo.repositorio.UsuarioRepositorio;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServicioTest {



    @Test
    public void registro_Exitoso(){
        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Cliente clienteEntrada =
                new Cliente("Natalia Álvarez",
                        "natalia@ejemplo.com",
                        "123", LocalDate.now(),
                        "313333333",
                        "AB0E43");
        Cliente clienteEsperado =
                new Cliente("Natalia Álvarez",
                        "natalia@ejemplo.com",
                        "123", LocalDate.now(),
                        "313333333",
                        "AB0E43");

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Mockito.when(usuarioRepositorio.buscarporCorreo(clienteEntrada.getCorreo()))
                .thenReturn(clienteEsperado);

         Usuario clienteResultado = usuarioServicio.registrarCliente(clienteEntrada);

        assertEquals(clienteResultado, clienteEsperado);
    }

    @Test
    public void correoDuplicado(){
        UsuarioRepositorio mockRepositorio = Mockito.mock(UsuarioRepositorio.class);
        when(mockRepositorio.buscarporCorreo("natalia@ejemplo.com"))
                .thenReturn(new Cliente(
                        "Natalia Álvarez",
                        "natalia@ejemplo.com",
                        "password123",
                        LocalDate.of(2001, 5, 20),
                        "333123456",
                        "A12345678"));


    }
}


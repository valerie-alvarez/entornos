//Hoja de pruebas de Usuario, cinco pruebas en total.
package org.pruebasUsuario.servicios;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pruebasUsuario.modelo.Admin;
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


/*Pruebas unitarias realizadas para los requerimientos
funcionales número uno, dos y tres. */
    @Test
    public void registro_Exitoso(){
        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Cliente clienteEntrada =
                new Cliente("Natalia Álvarez",
                        "natalia@ejemplo.com",
                        "123", LocalDate.now(),
                        "313333333",
                        "AB0E43");
        Mockito.when(usuarioRepositorio.buscarporCorreo(clienteEntrada.getCorreo()))
                .thenReturn(null).thenReturn(clienteEntrada);;

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Usuario clienteResultado = usuarioServicio.registrarCliente(clienteEntrada);

        assertEquals(clienteResultado, clienteEntrada);
    }

    @Test
    public void registroAdmin_Exitoso(){
        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Admin adminEntrada =
                new Admin("Valerie Álvarez",
                        "valerie@ejemplo.com",
                        "123"
                );

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Mockito.when(usuarioRepositorio.buscarporCorreo(adminEntrada.getCorreo()))
                .thenReturn(null).thenReturn(adminEntrada);;

        Usuario adminResultado = usuarioServicio.registrarAdmin(adminEntrada);

        assertEquals(adminResultado, adminEntrada);
    }

    @Test
    public void correoDuplicado(){
        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Cliente clienteEntrada =
                new Cliente("Natalia Álvarez",
                        "natalia@ejemplo.com",
                        "123",
                        LocalDate.now(),
                        "313333333",
                        "AB0E43");

        when(usuarioRepositorio.buscarporCorreo("natalia@ejemplo.com"))
                .thenReturn(clienteEntrada);

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioServicio.registrarCliente(
                    clienteEntrada
            );
        });
        assertEquals("El correo ya está registrado", exception.getMessage());
    }

    @Test
    public void inicioSesionExitoso(){
        String correoEntrada = "natalia@ejemplo.com";
        String contrasenaEntrada = "123";

        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        when(usuarioRepositorio.buscarporCorreoyContrasena(correoEntrada, contrasenaEntrada))
                .thenReturn(new Cliente("Natalia Álvarez", "natalia@ejemplo.com",
                        "123", LocalDate.of(1990, 5, 20),
                        "555123456", "A12345678"));

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Usuario usuario = usuarioServicio.iniciarSesion(correoEntrada, contrasenaEntrada);

        assertNotNull(usuario);
        assertEquals(correoEntrada, usuario.getCorreo());
        assertEquals(contrasenaEntrada, usuario.getContrasena());
    }

    @Test
    public void actualizarPerfil() {
        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        Cliente cliente = new Cliente("Natalia Álvarez",
                "natalia@ejemplo.com",
                "123",
                LocalDate.now(),
                "313333333",
                "AB0E43");

        //Cliente con nombre y pasaporte actualizados
        Cliente clienteEsperado = new Cliente("Valerie Osorio",
                "natalia@ejemplo.com",
                "123",
                LocalDate.now(),
                "313333333",
                "FM1D29");

        when(usuarioRepositorio.buscarporCorreo("natalia@ejemplo.com")).thenReturn(cliente);

        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarioRepositorio);

        Cliente clienteActualizado = usuarioServicio.actualizarPerfil(
                "natalia@ejemplo.com",
                "Valerie Osorio",
                "FM1D29");

        assertEquals(clienteEsperado.getNombre(), clienteActualizado.getNombre());
        assertEquals(clienteEsperado.getNumeroPasaporte(), clienteActualizado.getNumeroPasaporte());

        verify(usuarioRepositorio, times(1)).guardar(clienteActualizado);
    }
}


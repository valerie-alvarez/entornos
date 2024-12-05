package org;

import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;
import org.pruebasUsuario.modelo.repositorio.UsuarioRepositorio;
import org.pruebasUsuario.servicios.UsuarioServicio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//Crear un cliente.
        Cliente cliente1 =
                new Cliente("Natalia Álvarez",
                "natalia@ejemplo.com",
                "123", LocalDate.now(),
                "313333333",
                "AB0E43");
//Crear un servicio de usuario.
        UsuarioServicio usuarioServicio = new UsuarioServicio(new UsuarioRepositorio());
        }
    }

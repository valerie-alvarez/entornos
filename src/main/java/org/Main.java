package org;

import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;
import org.pruebasUsuario.modelo.repositorio.UsuarioRepositorio;
import org.pruebasUsuario.servicios.UsuarioServicio;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 =
                new Cliente("Natalia Álvarez",
                "natalia@ejemplo.com",
                "123", LocalDate.now(),
                "313333333",
                "AB0E43");
        UsuarioServicio usuarioServicio = new UsuarioServicio(new UsuarioRepositorio());
        }
    }

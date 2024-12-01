package org.example.modelo.repositorio;
import org.example.modelo.Usuario;


public interface UsuarioRepositorio {
    Usuario buscarporCorreo(String correo);
    Usuario buscarporCorreoyContrasena(String correo, String contrasena);

    void guardar(Usuario usuario);
}
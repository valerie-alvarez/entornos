package org.pruebasUsuario.modelo.repositorio;
import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;


public class UsuarioRepositorio {

    public void guardar(Usuario usuario){return;}
    public <T extends Usuario> T buscarporCorreo(String correo) {return null;}
    public <T extends Usuario> T buscarporCorreoyContrasena(String correo, String contrasena){return null;}

}

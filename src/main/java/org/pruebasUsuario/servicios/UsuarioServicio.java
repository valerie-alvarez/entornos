package org.pruebasUsuario.servicios;
import org.pruebasUsuario.modelo.Admin;
import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;
import org.pruebasUsuario.modelo.repositorio.UsuarioRepositorio;
import java.time.LocalDate;

 /*Constructor que inicializa el servicio de usuario. 
y UsuarioRepositorio es el repositorio para gestionar los usuarios. */

public class UsuarioServicio {

        private UsuarioRepositorio usuarioRepositorio;

        public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
            this.usuarioRepositorio = usuarioRepositorio;
        }

//Registrar cliente nuevo en el sistema.
    public Usuario registrarCliente(Cliente cliente){
            validarCorreoUnico(cliente.getCorreo());
            usuarioRepositorio.guardar(cliente);
            return usuarioRepositorio.buscarporCorreo(cliente.getCorreo());
    }
        
//Registrar cliente nuevo en el sistema.
    public Admin registrarAdmin(Admin admin) {
        validarCorreoUnico(admin.getCorreo());
        usuarioRepositorio.guardar(admin);
        return usuarioRepositorio.buscarporCorreo(admin.getCorreo());
    }

/*Verifica que el correo ingresado no esté registrado
previamente en el sistema. */
    private void validarCorreoUnico(String correo) {
        if (usuarioRepositorio.buscarporCorreo(correo) != null) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
    }

//Inicio de sesión de un usuario en el sistema.
    public Usuario iniciarSesion(String correo, String contrasena) {
            Usuario usuario = usuarioRepositorio.buscarporCorreoyContrasena(correo, contrasena);
            if (usuario == null) {
                throw new IllegalArgumentException("Credenciales incorrectas");
            }
            return usuario;
        }
        
//Actualizacion de perfil de un usuario
    public Cliente actualizarPerfil(String correo, String nuevoNombre, String nuevoPasaporte) {
        Cliente cliente = usuarioRepositorio.buscarporCorreo(correo);
        if (cliente == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        cliente.setNombre(nuevoNombre);
        cliente.setNumeroPasaporte(nuevoPasaporte);

        usuarioRepositorio.guardar(cliente);
        return cliente;


    }
    }



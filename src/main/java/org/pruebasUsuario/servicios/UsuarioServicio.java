package org.pruebasUsuario.servicios;
import org.pruebasUsuario.modelo.Admin;
import org.pruebasUsuario.modelo.Cliente;
import org.pruebasUsuario.modelo.Usuario;
import org.pruebasUsuario.modelo.repositorio.UsuarioRepositorio;
import java.time.LocalDate;

public class UsuarioServicio {

        private UsuarioRepositorio usuarioRepositorio;

        public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
            this.usuarioRepositorio = usuarioRepositorio;
        }

    public Usuario registrarCliente(Cliente cliente){
            validarCorreoUnico(cliente.getCorreo());
            usuarioRepositorio.guardar(cliente);
            return usuarioRepositorio.buscarporCorreo(cliente.getCorreo());
    }

    public Admin registrarAdmin(String nombre, String correo, String contrasena) {
        validarCorreoUnico(correo);

        Admin nuevoAdmin = new Admin(nombre, correo, contrasena, "Admin");
        usuarioRepositorio.guardar(nuevoAdmin);
        return  nuevoAdmin;
    }

    private void validarCorreoUnico(String correo) {
        if (usuarioRepositorio.buscarporCorreo(correo) != null) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
            Usuario usuario = usuarioRepositorio.buscarporCorreoyContrasena(correo, contrasena);
            if (usuario == null) {
                throw new IllegalArgumentException("Credenciales incorrectas");
            }
            return usuario;
        }

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



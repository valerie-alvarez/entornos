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
        usuarioRepositorio.guardar(cliente);
        return usuarioRepositorio.buscarporCorreo(cliente.getCorreo());
    }

    // Registrar Admin
    public Admin registrarAdmin(String nombre, String correo, String contrasena) {
        validarCorreoUnico(correo);

        Admin nuevoAdmin = new Admin(nombre, correo, contrasena, "Admin");
        usuarioRepositorio.guardar(nuevoAdmin);
        return  nuevoAdmin;
    }

    // Metodo común para validar que el correo sea único
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
        public Usuario actualizarPerfil(String correo, String nuevoNombre, String nuevoCorreo, String nuevoId, String nuevaDireccion, String nuevoTelefono, String nuevoNumeroPasaporte) {
            Usuario usuario = usuarioRepositorio.buscarporCorreo(correo);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
            usuario.setNombre(nuevoNombre);
            usuario.setCorreo(nuevoCorreo);
            usuario.setDireccion(nuevaDireccion);
            usuario.setTelefono(nuevoTelefono);
            usuario.setNumeroPasaporte(nuevoNumeroPasaporte);

            usuarioRepositorio.guardar(usuario);
            return usuario;
        }
    }



package org.example.servicios;
import org.example.modelo.Admin;
import org.example.modelo.Cliente;
import org.example.modelo.Usuario;
import org.example.modelo.repositorio.UsuarioRepositorio;
import java.time.LocalDate;

public class UsuarioServicio {
        //Instancia repositorio
        private final UsuarioRepositorio usuarioRepositorio;

        //Constructor
        public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
            this.usuarioRepositorio = usuarioRepositorio;
        }

    // Registrar Cliente
    public Cliente registrarCliente(String nombre, String correo, String contrasena, LocalDate fechaNacimiento, String telefono, String numeroPasaporte) {
        validarCorreoUnico(correo);
        Cliente nuevoCliente = new Cliente(nombre, correo, contrasena, "Cliente", fechaNacimiento, telefono, numeroPasaporte);
        usuarioRepositorio.guardar(nuevoCliente);
        return nuevoCliente;
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
        public Usuario actualizarPerfil(String correo, String nuevoNombre, String nuevoCorreo, String nuevoId) {
            Usuario usuario = usuarioRepositorio.buscarporCorreo(correo);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
            usuario.setNombre(nuevoNombre);
            usuario.setCorreo(nuevoCorreo);
            usuarioRepositorio.guardar(usuario);
            return usuario;
        }
    }



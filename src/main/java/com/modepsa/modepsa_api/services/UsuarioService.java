package com.modepsa.modepsa_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.modepsa.modepsa_api.dto.UsuarioRequestDTO;
import com.modepsa.modepsa_api.models.Usuario;
import com.modepsa.modepsa_api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepositorio;

    public UsuarioService(UsuarioRepository instancia) {
        this.usuarioRepositorio = instancia;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));
    }

    public Usuario guardarUsuario(UsuarioRequestDTO usuarioDatos) {
        if (usuarioRepositorio.existsByDniIgnoreCaseOrCorreoIgnoreCaseOrCelularIgnoreCase(usuarioDatos.dni().trim(), usuarioDatos.correo().trim(),usuarioDatos.celular().trim())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese DNI, corr  eo o celular.");
        }
        Usuario user = new Usuario();
        copiarDatos(usuarioDatos, user);

        return usuarioRepositorio.save(user);
    }

    public Usuario actualizarUsuario(Long id, UsuarioRequestDTO usuarioDatos) {
        Usuario usuarioObtenido = obtenerUsuarioPorId(id);

        copiarDatos(usuarioDatos, usuarioObtenido);

        return usuarioRepositorio.save(usuarioObtenido);
    }

    public void eliminarUsuario(Long id) {
        Usuario user = obtenerUsuarioPorId(id);
        usuarioRepositorio.deleteById(user.getId());
    }

    private void copiarDatos(UsuarioRequestDTO datos, Usuario user) {
        user.setNombres(datos.nombres().trim());
        user.setApellidos(datos.apellidos().trim());
        user.setCelular(datos.celular().trim());
        user.setCorreo(datos.correo().trim());
        user.setDni(datos.dni().trim());
        user.setEdad(datos.edad());
        user.setEstado(datos.estado());
        user.setRol(datos.rol());
    }
}

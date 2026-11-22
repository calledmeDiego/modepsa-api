package com.modepsa.modepsa_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepositorio.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNombres(usuario.getNombres());
                    usuarioExistente.setApellidos(usuario.getApellidos());
                    usuarioExistente.setEdad(usuario.getEdad());
                    usuarioExistente.setCorreo(usuario.getCorreo());
                    usuarioExistente.setCelular(usuario.getCelular());
                    usuarioExistente.setRuc(usuario.getRuc());
                    usuarioExistente.setEstado(usuario.getEstado());
                    usuarioExistente.setRol(usuario.getRol());
                    return usuarioRepositorio.save(usuarioExistente);
                })
                .orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}

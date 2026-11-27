package com.modepsa.modepsa_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modepsa.modepsa_api.models.Usuario;

public interface UsuarioRepository extends  JpaRepository<Usuario, Long>{
    boolean existsByDniIgnoreCaseOrCorreoIgnoreCaseOrCelularIgnoreCase(
            String dni,
            String correo,
            String celular
    );
}

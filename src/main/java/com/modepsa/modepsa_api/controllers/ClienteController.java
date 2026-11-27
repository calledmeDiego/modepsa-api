package com.modepsa.modepsa_api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modepsa.modepsa_api.dto.cliente.ClienteResponseDTO;
import com.modepsa.modepsa_api.models.Usuario;
import com.modepsa.modepsa_api.services.ClienteService;
import com.modepsa.modepsa_api.services.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Operaciones de gestión de clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarUsuarios() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}

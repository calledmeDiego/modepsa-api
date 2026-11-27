package com.modepsa.modepsa_api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.modepsa.modepsa_api.dto.UsuarioRequestDTO;
import com.modepsa.modepsa_api.dto.cliente.ClienteRequestDTO;
import com.modepsa.modepsa_api.dto.cliente.ClienteResponseDTO;
import com.modepsa.modepsa_api.models.Usuario;
import com.modepsa.modepsa_api.services.ClienteService;
import com.modepsa.modepsa_api.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

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


    @Operation(summary = "Obtener cliente", description = "Consulta un cliente mediante su identificador.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorId(@PathVariable Long id) {
        ClienteResponseDTO user = clienteService.buscarPorId(id);
        if (user == null) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<ClienteResponseDTO> guardarUsuario(@Valid @RequestBody ClienteRequestDTO cliente) {
        ClienteResponseDTO nuevoCliente = clienteService.registrarCliente(cliente);
        URI ubicacion = URI.create("api/clientes/" + nuevoCliente.id());
        return ResponseEntity.created(ubicacion).body(nuevoCliente);
    }
}

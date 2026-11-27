package com.modepsa.modepsa_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modepsa.modepsa_api.dto.cliente.ClienteResponseDTO;
import com.modepsa.modepsa_api.repository.ClienteRepository;
import com.modepsa.modepsa_api.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service 
public class ClienteService {
    private final ClienteRepository clienteRepositorio;

    public ClienteService(ClienteRepository clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Transactional()
    public List<ClienteResponseDTO> listarClientes() {
        return clienteRepositorio.findAll()
                .stream()
                .map(ClienteResponseDTO::fromEntity)
                .toList();
    }
}

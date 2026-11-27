package com.modepsa.modepsa_api.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.modepsa.modepsa_api.dto.UsuarioRequestDTO;
import com.modepsa.modepsa_api.dto.cliente.ClienteRequestDTO;
import com.modepsa.modepsa_api.dto.cliente.ClienteResponseDTO;
import com.modepsa.modepsa_api.models.Cliente;
import com.modepsa.modepsa_api.models.Estado;
import com.modepsa.modepsa_api.models.Usuario;
import com.modepsa.modepsa_api.repository.ClienteRepository;

import org.springframework.transaction.annotation.Transactional;

@Service 
public class ClienteService {
    private final ClienteRepository clienteRepositorio;

    public ClienteService(ClienteRepository clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> listarClientes() {
        return clienteRepositorio.findAll()
                .stream()
                .map(ClienteResponseDTO::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = findClienteOrThrow(id);
        return ClienteResponseDTO.fromEntity(cliente);
    }

    public ClienteResponseDTO registrarCliente(ClienteRequestDTO dto) {
        if (clienteRepositorio.existsByTipoDocumentoAndNumeroDocumento(dto.tipoDocumento(), dto.numeroDocumento().trim())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un cliente con ese número de documento.");
        }

        Cliente cliente = new Cliente();
        copiarDatos(dto, cliente);

        Cliente guardado = clienteRepositorio.save(cliente);
        return ClienteResponseDTO.fromEntity(guardado);
    }



    private Cliente findClienteOrThrow(Long id) {
        return clienteRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado con ID: " + id));
    }

    private void copiarDatos(ClienteRequestDTO datos, Cliente user) {
        user.setNombres(datos.nombres().trim());
        user.setApellidos(datos.apellidos().trim());
        user.setCelular(datos.celular().trim());
        user.setCorreo(datos.correo().trim());
        user.setDireccion(datos.direccion().trim());
        user.setNumeroDocumento(datos.numeroDocumento().trim());
        user.setRazonSocial(datos.razonSocial().trim());
        user.setTipoDocumento(datos.tipoDocumento());
        user.setEstado(datos.estado() != null ? datos.estado() : Estado.ACTIVO);
    }
}

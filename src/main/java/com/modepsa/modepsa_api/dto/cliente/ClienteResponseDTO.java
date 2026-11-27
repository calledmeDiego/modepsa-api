package com.modepsa.modepsa_api.dto.cliente;

import com.modepsa.modepsa_api.models.Cliente;
import com.modepsa.modepsa_api.models.Estado;
import com.modepsa.modepsa_api.models.TipoDocumento;

public record ClienteResponseDTO(
        Long id,
        TipoDocumento tipoDocumento,
        String numeroDocumento,
        String nombres,
        String apellidos,
        String razonSocial,
        String correo,
        String celular,
        String direccion,
        Estado estado) {

    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getTipoDocumento(),
                cliente.getNumeroDocumento(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getRazonSocial(),
                cliente.getCorreo(),
                cliente.getCelular(),
                cliente.getDireccion(),
                cliente.getEstado());
    }
}

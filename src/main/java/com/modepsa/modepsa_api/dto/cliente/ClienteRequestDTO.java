package com.modepsa.modepsa_api.dto.cliente;

import com.modepsa.modepsa_api.models.Estado;
import com.modepsa.modepsa_api.models.TipoDocumento;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(
        @NotNull(message = "El tipo de documento es obligatorio")
        TipoDocumento tipoDocumento,

        @NotBlank(message = "El número de documento es obligatorio")
        @Size(min = 8, max = 20, message = "El número de documento debe tener entre 8 y 20 caracteres")
        @Pattern(
                regexp = "^[A-Za-z0-9-]+$",
                message = "El número de documento solo puede contener letras, números o guiones"
        )
        String numeroDocumento,

        @NotBlank(message = "Los nombres son obligatorios")
        @Size(max = 50, message = "Los nombres no pueden superar los 50 caracteres")
        String nombres,

        @NotBlank(message = "Los apellidos son obligatorios")
        @Size(max = 50, message = "Los apellidos no pueden superar los 50 caracteres")
        String apellidos,

        @Size(max = 150, message = "La razón social no puede superar los 150 caracteres")
        String razonSocial,

        @Size(max = 70, message = "El correo electrónico no puede superar los 120 caracteres")
        @Email(message = "El formato del correo electrónico no es válido")
        String correo,

        @Size(max = 20, message = "El celular no puede superar los 20 caracteres")
        String celular,

        @Size(max = 200, message = "La dirección no puede superar los 200 caracteres")
        String direccion,

        Estado estado) {
    
}

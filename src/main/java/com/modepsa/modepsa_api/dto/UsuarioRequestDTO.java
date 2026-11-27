package com.modepsa.modepsa_api.dto;

import com.modepsa.modepsa_api.models.Estado;
import com.modepsa.modepsa_api.models.Rol;
import com.modepsa.modepsa_api.models.TipoDocumento;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotBlank(message = "Los nombres son obligatorios") 
        @Size(max = 100, message = "Los nombres no pueden superar los 100 caracteres")
        String nombres,

        @NotBlank(message = "Los apellidos son obligatorios") 
        @Size(max = 100, message = "Los apellidos no pueden superar los 100 caracteres") 
        String apellidos,

        @Min(value = 18, message = "La edad mínima es 18 años") 
        @Max(value = 100, message = "La edad máxima es 100 años") 
        Integer edad,

        @NotBlank(message = "El correo electrónico es obligatorio") 
        @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres") 
        @Email(message = "El formato del correo electrónico no es válido") 
        String correo,

        @Size(max = 15, message = "El celular no puede superar los 15 caracteres") 
        @Pattern(regexp = "^9\\d{8}$", message = "El celular en Perú debe tener 9 dígitos y empezar con 9") String celular,

        @Size(min = 8, max = 11, message = "El documento debe tener entre 8 y 11 caracteres") 
        @Pattern(regexp = "^(\\d{8}|\\d{11})$", message = "El DNI debe tener 8 dígitos o el RUC 11 dígitos") String dni,

        @NotNull(message = "El estado es obligatorio") 
        Estado estado,

        @NotNull(message = "El rol es obligatorio") 
        Rol rol,

        @NotBlank(message = "La contraseña es obligatoria") @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#._-])[A-Za-z\\d@$!%*?&#._-]{8,20}$", message = "La contraseña debe incluir mayúscula, minúscula, número y carácter especial") String password) {
}
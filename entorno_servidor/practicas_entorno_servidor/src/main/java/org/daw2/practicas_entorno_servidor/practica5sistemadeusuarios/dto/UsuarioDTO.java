package org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class UsuarioDTO {
    @NotBlank
    @Size(min = 4, max = 15)
    private String username;

    @Email
    @NotBlank
    private String email;

    @Min(18)
    private int edad;

    @Pattern(regexp = "\\d{5}", message = "El código postal debe tener 5 dígitos")
    private String codigoPostal;
}

package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlumnoDTO2 {
    @Min(1)
    private int id;

    @NotBlank
    @Size(min=2, max=40)
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @Min(16)
    @Max(99)
    private int edad;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double notaMedia;

    @Pattern(regexp = "^[A-Z]{3}\\\\d{4}$")
    private String expediente;
}

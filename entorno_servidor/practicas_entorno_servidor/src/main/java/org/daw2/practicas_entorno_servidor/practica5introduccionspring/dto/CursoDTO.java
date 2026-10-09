package org.daw2.practicas_entorno_servidor.practica5introduccionspring.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    // No puede ser nulo ni estar compuesto solo por espacios en blanco
    @NotBlank(message = "El nombre del curso es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre del curso debe tener entre 3 y 50 caracteres")
    private String nombre;
    // Formato válido de email
    @NotBlank(message = "El email del profesor es obligatorio")
    @Email(message = "Debe proporcionar una dirección de email válida")
    private String emailProfesor;
    // Número entero dentro de un rango
    @Min(value = 1, message = "El curso debe durar al menos 1 hora")
    @Max(value = 500, message = "El curso no puede superar las 500 horas")
    private int horas;
    // Valor decimal con un mínimo
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    private double precio;
}

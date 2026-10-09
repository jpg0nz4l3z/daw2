package org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class VehiculoDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private double precioPorDia;
    private boolean electrico;
}

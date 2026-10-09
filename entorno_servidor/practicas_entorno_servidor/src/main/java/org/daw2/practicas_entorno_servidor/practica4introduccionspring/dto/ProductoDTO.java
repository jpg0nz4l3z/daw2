package org.daw2.practicas_entorno_servidor.practica4introduccionspring.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductoDTO {
    private String nombre;
    private double precio;
    private boolean disponible;
}
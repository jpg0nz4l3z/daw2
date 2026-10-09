package org.daw2.practicas_entorno_servidor.practica4registroincidencias.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IncidenciaDTO {
    private int id;
    private String aula;
    private String descripcion;
    private boolean resuelta;
}

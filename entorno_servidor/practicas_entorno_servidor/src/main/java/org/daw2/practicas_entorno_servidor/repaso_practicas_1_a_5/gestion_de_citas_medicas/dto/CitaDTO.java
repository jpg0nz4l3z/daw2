package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {
    private int identificador;
    private String nombrePaciente;
    private String medico;
    private String fecha;
    private boolean urgente;
}

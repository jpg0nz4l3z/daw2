package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String dni;
    private String nombre;
    private double saldo;
    private boolean vip;
}

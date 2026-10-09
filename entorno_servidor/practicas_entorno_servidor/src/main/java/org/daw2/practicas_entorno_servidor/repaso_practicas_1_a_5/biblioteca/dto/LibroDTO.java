package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private String isbn;
    private String titulo;
    private String author;
    private int paginas;
    private boolean prestado;
}

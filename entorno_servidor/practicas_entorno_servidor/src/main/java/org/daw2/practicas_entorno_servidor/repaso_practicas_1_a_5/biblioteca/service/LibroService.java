package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.service;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.dto.LibroDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private List<LibroDTO> libros;

    public LibroService(){
        libros = new ArrayList<>(List.of(
                new LibroDTO("1", "titulo-1","author-1", 55, false),
                new LibroDTO("21", "titulo-2","author-2", 55, false),
                new LibroDTO("3", "titulo-3","author-3", 55, false),
                new LibroDTO("4", "titulo-4","author-4", 55, false),
                new LibroDTO("5", "titulo-5","author-5", 55, false)
        ));
    }

    public List<LibroDTO> listarLibros(){
        return libros;
    }

    public String guardar(LibroDTO libro){
        libros.add(libro);
        return String.format("Libro con isbn %s añadido correctamente", libro.getIsbn());
    }

    public List<LibroDTO> buscarLibro(String isbn){
        return libros.stream().filter(l -> l.getIsbn().toLowerCase().contains(isbn))
                .collect(Collectors.toList());
    }
}

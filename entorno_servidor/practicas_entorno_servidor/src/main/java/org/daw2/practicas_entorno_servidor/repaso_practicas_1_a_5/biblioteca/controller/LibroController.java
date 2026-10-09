package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.controller;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.dto.LibroDTO;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @GetMapping("/listar")
    public List<LibroDTO> listarLibros(){
        return libroService.listarLibros();
    }

    @GetMapping("/buscar/{isbn}")
    public List<LibroDTO> buscarLibro1(@PathVariable String isbn){
        return libroService.buscarLibro(isbn);
    }

    @GetMapping("/buscar")
    public List<LibroDTO> buscarLibro2(@RequestParam(required = true) String isbn){
        return libroService.buscarLibro(isbn);
    }

    @PostMapping("/nuevo")
    public String nuevo(@RequestBody LibroDTO libro){
        return libroService.guardar(libro);
    }
}

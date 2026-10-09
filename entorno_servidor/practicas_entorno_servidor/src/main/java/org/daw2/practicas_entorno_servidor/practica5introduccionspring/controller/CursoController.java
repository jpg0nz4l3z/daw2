package org.daw2.practicas_entorno_servidor.practica5introduccionspring.controller;

import jakarta.validation.Valid;
import org.daw2.practicas_entorno_servidor.practica5introduccionspring.dto.CursoDTO;
import org.daw2.practicas_entorno_servidor.practica5introduccionspring.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @GetMapping("/todos")
    public List<CursoDTO> obtenerTodos() {
        return cursoService.obtenerCursos();
    }
    // Al poner @Valid, Spring comprueba las reglas de CursoDTO ANTES de entrar al método
    @PostMapping("/crear")
    public String crearCurso(@Valid @RequestBody CursoDTO nuevoCurso) {
        return cursoService.guardarCurso(nuevoCurso);
    }
}

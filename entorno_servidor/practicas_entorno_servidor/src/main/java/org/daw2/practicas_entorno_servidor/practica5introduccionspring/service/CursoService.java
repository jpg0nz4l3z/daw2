package org.daw2.practicas_entorno_servidor.practica5introduccionspring.service;

import org.daw2.practicas_entorno_servidor.practica5introduccionspring.dto.CursoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    private final List<CursoDTO> cursos = new ArrayList<>();
    public CursoService() {
        cursos.add(new CursoDTO("Desarrollo Web Servidor", "profe@daw.com", 160, 0.0));
    }
    public List<CursoDTO> obtenerCursos() {
        return cursos;
    }
    public String guardarCurso(CursoDTO nuevoCurso) {
        cursos.add(nuevoCurso);
        return "Curso '" + nuevoCurso.getNombre() + "' registrado correctamente con " +
                nuevoCurso.getHoras() + "h.";
    }
}
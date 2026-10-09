package org.daw2.practicas_entorno_servidor.practica4registroincidencias.controller;

import org.daw2.practicas_entorno_servidor.practica4registroincidencias.dto.IncidenciaDTO;
import org.daw2.practicas_entorno_servidor.practica4registroincidencias.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incidencias")
public class IncidenciaController {

    @Autowired
    IncidenciaService incidenciaService;

    @GetMapping("/todas")
    public List<IncidenciaDTO> todas(){
        return incidenciaService.obtenerTodas();
    }

    @PostMapping("/crear")
    public String crear(@RequestBody IncidenciaDTO incidencia){
        return incidenciaService.registrarIncidencia(incidencia);
    }
}

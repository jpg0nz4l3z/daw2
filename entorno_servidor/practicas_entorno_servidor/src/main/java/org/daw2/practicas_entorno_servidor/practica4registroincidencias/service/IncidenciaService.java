package org.daw2.practicas_entorno_servidor.practica4registroincidencias.service;

import org.daw2.practicas_entorno_servidor.practica4registroincidencias.dto.IncidenciaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenciaService {

    private List<IncidenciaDTO> incidencias;

    public IncidenciaService(){
        this.incidencias = new ArrayList<IncidenciaDTO>(List.of(
                new IncidenciaDTO(1, "aula-1", "descripción-1", true),
                new IncidenciaDTO(2, "aula-2", "descripción-2", false),
                new IncidenciaDTO(3, "aula-3", "descripción-3", true),
                new IncidenciaDTO(4, "aula-4", "descripción-4", false)
        ));
    }

    public List<IncidenciaDTO> obtenerTodas(){
        return incidencias;
    }

    public String registrarIncidencia(IncidenciaDTO incidencia){
        incidencias.add(incidencia);

        return incidencia.toString() + " ¡REGISTRADA CON EXITO!";
    }
}

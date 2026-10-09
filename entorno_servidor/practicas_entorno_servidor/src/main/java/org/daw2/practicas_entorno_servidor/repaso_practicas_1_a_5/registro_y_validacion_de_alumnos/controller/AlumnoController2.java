package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.controller;

import jakarta.validation.Valid;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.dto.AlumnoDTO2;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.service.AlumnoService2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos2")
public class AlumnoController2 {
    private AlumnoService2 alumnoService;

    public AlumnoController2(AlumnoService2 alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping("/todos")
    public List<AlumnoDTO2> getAll(){
        return alumnoService.listAll();
    }

    @GetMapping("/aprobados")
    public List<AlumnoDTO2> getAprobados(){
        return alumnoService.obtenerAlumnosAprobados();
    }

    @PostMapping("/matricular")
    public String matricular(@Valid @RequestBody AlumnoDTO2 alumno){
        return alumnoService.matricularAlumno(alumno);
    }
}

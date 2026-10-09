package org.daw2.practicas_entorno_servidor.practica2introduccionspring.controller;

import org.daw2.practicas_entorno_servidor.practica2introduccionspring.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 2. Ruta base para todos los métodos de este controlador
@RequestMapping("/alumnos")
public class AlumnoController {
    // 3. Inyectamos la capa de servicio
    @Autowired
    private AlumnoService alumnoService;
    // RUTA 1: Uso de @RequestParam
    // URL de prueba: http://localhost:8080/alumnos/saludo?nombre=Carlos
    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestParam(required = false) String nombre) {
        // Delegamos la responsabilidad al Servicio (Camarero -> Cocinero)
        return alumnoService.generarSaludoPersonalizado(nombre);
    }
    // RUTA 2: Uso de @PathVariable
    // URL de prueba: http://localhost:8080/alumnos/evaluar/7.5
    @GetMapping("/evaluar/{nota}")
    public String evaluarAlumno(@PathVariable double nota) {
        // Delegamos el cálculo de la nota a la Capa de Servicio
        return alumnoService.evaluarNota(nota);
    }
}
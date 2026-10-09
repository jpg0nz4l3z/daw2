package org.daw2.practicas_entorno_servidor.practica2introduccionspring.service;

import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    // Método 1: Lógica sencilla para personalizar un saludo
    public String generarSaludoPersonalizado(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "¡Hola, alumno/a anónimo/a de DAW!";
        }
        return "¡Hola, " + nombre + "! Bienvenido a la asignatura de DWES.";
    }
    // Método 2: Lógica de negocio (evaluar una nota)
    public String evaluarNota(double nota) {
        if (nota < 0 || nota > 10) {
            return "Error: La nota debe estar entre 0 y 10.";
        } else if (nota >= 5) {
            return "El alumno ha APROBADO con un " + nota;
        } else {
            return "El alumno ha SUSPENDIDO con un " + nota;
        }
    }
}
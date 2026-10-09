package org.daw2.practicas_entorno_servidor.practica1introduccionspring.service;

import org.springframework.stereotype.Component;

@Component
public class SaludoService {
    public String obtenerSaludo() {
        return "¡Hola! Este mensaje ha sido generado por un objeto (Bean) administrado por Spring.";
    }
}
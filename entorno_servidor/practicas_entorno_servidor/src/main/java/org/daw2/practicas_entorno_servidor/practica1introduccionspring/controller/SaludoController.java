package org.daw2.practicas_entorno_servidor.practica1introduccionspring.controller;

import org.daw2.practicas_entorno_servidor.practica1introduccionspring.service.SaludoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    // 2. Inyección de Dependencias: pedimos a Spring que nos entregue la instancia de SaludoService
    @Autowired
    private SaludoService saludoService;
    // 3. Mapeamos la ruta URL http://localhost:8080/saludo
    @GetMapping("/saludo")
    public String saludar() {
        // Usamos el servicio SIN haber hecho un 'new SaludoService()'
        return saludoService.obtenerSaludo();
    }
}

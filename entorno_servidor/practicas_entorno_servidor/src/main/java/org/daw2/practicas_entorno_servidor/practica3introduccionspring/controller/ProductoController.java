package org.daw2.practicas_entorno_servidor.practica3introduccionspring.controller;

import org.daw2.practicas_entorno_servidor.practica3introduccionspring.dto.ProductoDTO;
import org.daw2.practicas_entorno_servidor.practica3introduccionspring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    // URL: http://localhost:8080/productos/detalle
    @GetMapping("/detalle")
    public ProductoDTO obtenerDetalle() {
        return productoService.obtenerProductoEjemplo();
    }
    // URL: http://localhost:8080/productos/catalogo
    @GetMapping("/catalogo")
    public List<ProductoDTO> obtenerTodos() {
        return productoService.obtenerCatalogo();
    }
}

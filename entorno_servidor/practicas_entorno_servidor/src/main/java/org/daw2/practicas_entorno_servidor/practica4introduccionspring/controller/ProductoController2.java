package org.daw2.practicas_entorno_servidor.practica4introduccionspring.controller;

import org.daw2.practicas_entorno_servidor.practica4introduccionspring.dto.ProductoDTO;
import org.daw2.practicas_entorno_servidor.practica4introduccionspring.service.ProductoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products2")
public class ProductoController2 {
    @Autowired
    private ProductoService2 productoService2;
    // GET: Obtener todos los productos
    @GetMapping("/catalogo")
    public List<ProductoDTO> obtenerTodos() {
        return productoService2.obtenerCatalogo();
    }
    // POST: Recibir un JSON en el cuerpo de la petición y guardarlo
    @PostMapping("/crear")
    public String crearProducto(@RequestBody ProductoDTO nuevoProducto) {
        return productoService2.guardarProducto(nuevoProducto);
    }
}
package org.daw2.practicas_entorno_servidor.practica4introduccionspring.service;

import org.daw2.practicas_entorno_servidor.practica4introduccionspring.dto.ProductoDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService2 {
    // Lista en memoria que actuará como nuestra "base de datos" temporal
    private final List<ProductoDTO> catalogo = new ArrayList<>();
    public ProductoService2() {
        // Datos iniciales
        catalogo.add(new ProductoDTO("Teclado Mecánico", 60.00, true));
        catalogo.add(new ProductoDTO("Monitor 24 pulgadas", 140.00, false));
    }
    public List<ProductoDTO> obtenerCatalogo() {
        return catalogo;
    }
    // Nuevo método para guardar un producto enviado por el usuario
    public String guardarProducto(ProductoDTO nuevoProducto) {
        catalogo.add(nuevoProducto);
        return "Producto '" + nuevoProducto.getNombre() + "' añadido correctamente. Total en catálogo: " + catalogo.size();
    }
}


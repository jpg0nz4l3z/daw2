package org.daw2.practicas_entorno_servidor.practica3introduccionspring.service;

import org.daw2.practicas_entorno_servidor.practica3introduccionspring.dto.ProductoDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService {
    public ProductoDTO obtenerProductoEjemplo() {
        return new ProductoDTO("Ratón Inalámbrico", 25.50, true);
    }
    public List<ProductoDTO> obtenerCatalogo() {
        List<ProductoDTO> catalogo = new ArrayList<>();
        catalogo.add(new ProductoDTO("Teclado Mecánico", 60.00, true));
        catalogo.add(new ProductoDTO("Monitor 24 pulgadas", 140.00, false));
        catalogo.add(new ProductoDTO("Auriculares Gaming", 35.99, true));
        return catalogo;
    }
}

package org.daw2.practicas_entorno_servidor.practica2tienda.service;

import org.springframework.stereotype.Service;

@Service
public class TiendaService {

    public String calcularDescuento(double precio, double porcenaje){
        double precioFinal = precio - (precio * porcenaje / 100);
        return String.format("Precio original: %.2f€, porcentaje aplicado: %.2f€, precio final %.2f€", precio, porcenaje, precioFinal);
    }

    public String verificarStock(int n){

        String message = "";

        if(n <= 0) {
            message = "Producto Agotado";
        }else if(n <= 5){
            message = String.format("¡Últimas unidades! Quedan %d en stock",n);
        }else{
            message = String.format("Stock disponible: %d unidades", n);
        }

        return message;
    }
}


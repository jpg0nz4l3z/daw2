package org.daw2.practicas_entorno_servidor.practica2tienda.controller;

import org.daw2.practicas_entorno_servidor.practica2tienda.service.TiendaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tienda")
public class TiendaController {

    private final TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService){
        this.tiendaService = tiendaService;
    }

    @GetMapping("/descuento")
    public String descuento(@RequestParam(required = true) double precio, @RequestParam(required = false, defaultValue = "10.0") double descuento){
        return String.format("<h1 style='background: LightBlue; padding-top: 50px; padding-bottom: 50px; color: blue; font-size: 100px; font-family: Century Gothic, AppleGothic, Apple SD Gothic Neo, sans-serif;'>%s</h1>",tiendaService.calcularDescuento(precio, descuento));
    }

    @GetMapping("/stock/{unidades}")
    public String verificarStock(@PathVariable int unidades){
        return String.format("<h1 style='background: LightBlue; padding-top: 50px; padding-bottom: 50px; color: blue; font-size: 100px; font-family: Comic Sans MS, Comic Sans, cursive;'>%s</h1>",tiendaService.verificarStock(unidades));
    }
}

package org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.controller;

import org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.service.VehicleService;
import org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.dto.VehiculoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/todos")
    public List<VehiculoDTO> todos(){
        return vehicleService.obtenerListaCompleta();
    }

    @GetMapping("/buscar/{matricula}")
    public List<VehiculoDTO> buscar(@PathVariable String matricula){
        return vehicleService.buscarPorMatricula(matricula);
    }

    @GetMapping("/electricos")
    public List<VehiculoDTO> soloElectricos(){
        return vehicleService.obtenerElectricos();
    }
}

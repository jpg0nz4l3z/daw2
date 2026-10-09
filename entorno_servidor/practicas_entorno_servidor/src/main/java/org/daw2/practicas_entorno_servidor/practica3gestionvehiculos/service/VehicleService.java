package org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.service;

import org.daw2.practicas_entorno_servidor.practica3gestionvehiculos.dto.VehiculoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private List<VehiculoDTO> vehicleList;

    public VehicleService(){
        vehicleList = new ArrayList<>(List.of(
                new VehiculoDTO("matricula-1", "marca-1", "modelo-1", 10.1, true),
                new VehiculoDTO("matricula-2", "marca-2", "modelo-2", 10.2, false),
                new VehiculoDTO("matricula-3", "marca-3", "modelo-3", 10.3, true),
                new VehiculoDTO("matricula-4", "marca-4", "modelo-4", 10.4, false),
                new VehiculoDTO("matricula-5", "marca-5", "modelo-5", 10.5, true),
                new VehiculoDTO("matricula-6", "marca-6", "modelo-6", 10.6, false),
                new VehiculoDTO("matricula-7", "marca-7", "modelo-7", 10.7, true)
        ));
    }

    public List<VehiculoDTO> obtenerListaCompleta(){
        return vehicleList;
    }

    public List<VehiculoDTO> buscarPorMatricula(String matricula){
        return  vehicleList.stream()
                .filter(v -> v.getMatricula().toLowerCase().contains(matricula.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<VehiculoDTO> obtenerElectricos(){
        return  vehicleList.stream()
                .filter(VehiculoDTO::isElectrico)
                .collect(Collectors.toList());
    }
}

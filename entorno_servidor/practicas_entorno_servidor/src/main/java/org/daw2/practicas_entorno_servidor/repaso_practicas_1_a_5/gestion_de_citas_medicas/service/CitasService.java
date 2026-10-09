package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.service;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.dto.CitaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CitasService {
    private List<CitaDTO> citas;

    public CitasService(){
        citas = new ArrayList<CitaDTO>(List.of(
           new CitaDTO(1, "nombre-1", "medico-1", "10/09/2026", true),
           new CitaDTO(1, "nombre-2", "medico-2", "10/09/2026", false),
           new CitaDTO(1, "nombre-32", "medico-3", "10/09/2026", true),
           new CitaDTO(1, "nombre-4", "medico-41", "10/09/2026", false)
        ));
    }

    public List<CitaDTO> listar(){
        return citas;
    }

    public String agregarCita(CitaDTO cita){
        citas.add(cita);
        return String.format("Cita con id %d y fecha %s agregada exitosamente!", cita.getIdentificador(), cita.getFecha());
    }

    public List<CitaDTO> buscarUrgentes(){
        return citas.stream().filter(CitaDTO::isUrgente).collect(Collectors.toList());
    }

    public List<CitaDTO> buscarPorMedico(String medico){
        return citas.stream().filter(c -> c.getMedico().toLowerCase().contains(medico)).collect(Collectors.toList());
    }
}

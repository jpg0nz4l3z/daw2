package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.controller;

import jakarta.validation.Valid;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.dto.CitaDTO;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.gestion_de_citas_medicas.service.CitasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitasController {
    public final CitasService citasService;

    public CitasController(CitasService citasService){
        this.citasService = citasService;
    }

    @GetMapping("/citas/urgentes")
    public List<CitaDTO> urgentes(){
        return citasService.buscarUrgentes();
    }

    @GetMapping("/buscar/{medico}")
    public List<CitaDTO> buscarPorMedico1(@PathVariable String medico){
        return citasService.buscarPorMedico(medico);
    }

    @GetMapping("/buscar")
    public List<CitaDTO> buscarPorMedico2(@RequestParam(required = true) String medico){
        return citasService.buscarPorMedico(medico);
    }

    @PostMapping("/citas/agendar")
    public String agendar(@Valid @RequestBody CitaDTO citaDto){
        return citasService.agregarCita(citaDto);
    }
}

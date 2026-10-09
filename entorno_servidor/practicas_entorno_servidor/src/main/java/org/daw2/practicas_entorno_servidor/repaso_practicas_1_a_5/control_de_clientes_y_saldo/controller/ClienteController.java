package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.controller;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.dto.ClienteDTO;
import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<ClienteDTO> listarTodos(){
        return clienteService.listar();
    }

    @PostMapping("/registro")
    public String registrar(@RequestBody(required = true) ClienteDTO cliente){
        return clienteService.registrarCliente(cliente);
    }

    @PostMapping("/ingreso")
    public boolean ingreso(@RequestParam String dni,@RequestParam double cantidad){
        return clienteService.ingresarDinero(dni, cantidad);
    }

    @PostMapping("/ingreso/{dni}-{cantidad}")
    public boolean ingreso2(@PathVariable String dni,@PathVariable double cantidad){
        return clienteService.ingresarDinero(dni, cantidad);
    }
}

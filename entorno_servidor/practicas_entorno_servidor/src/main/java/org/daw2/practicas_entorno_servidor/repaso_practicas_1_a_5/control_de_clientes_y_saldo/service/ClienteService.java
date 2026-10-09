package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.service;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.control_de_clientes_y_saldo.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private List<ClienteDTO> clientes;

    public ClienteService(){
        clientes = new ArrayList<ClienteDTO>(List.of(
                new ClienteDTO("dni-1", "nombre-1", 10.3, true),
                new ClienteDTO("dni-1", "nombre-1", 10.3, false),
                new ClienteDTO("dni-1", "nombre-1", 10.3, true),
                new ClienteDTO("dni-1", "nombre-1", 10.3, false),
                new ClienteDTO("dni-1", "nombre-1", 10.3, false)
        ));
    }

    public List<ClienteDTO> listar(){
        return clientes;
    }

    public String registrarCliente(ClienteDTO cliente){
        clientes.add(cliente);
        return String.format("El cliente con dni %s y nombre %s fue añadido exitosamente!", cliente.getDni(), cliente.getNombre());
    }

    public boolean ingresarDinero(String dni, double cantidad){
        return clientes.stream().filter(c -> c.getDni().equals(dni))
                .findFirst()
                .map(c -> {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }).orElse(false);
    }
}

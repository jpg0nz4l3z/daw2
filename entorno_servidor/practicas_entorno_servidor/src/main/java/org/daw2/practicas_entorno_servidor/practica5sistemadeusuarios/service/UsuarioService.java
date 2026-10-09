package org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.service;

import org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<UsuarioDTO> usuarios;

    public UsuarioService(){
        this.usuarios = new ArrayList<>(List.of(
           new UsuarioDTO("usuario1", "usuario1@gmail.com", 1, "12345"),
           new UsuarioDTO("usuario2", "usuario2@gmail.com", 1, "67890"),
           new UsuarioDTO("usuario3", "usuario3@gmail.com", 1, "34532"),
           new UsuarioDTO("usuario4", "usuario4@gmail.com", 1, "19283"),
           new UsuarioDTO("usuario5", "usuario5@gmail.com", 1, "09162")
        ));
    }

    public List<UsuarioDTO> obtenerTodos(){
        return usuarios;
    }

    public String registrarUsuario(UsuarioDTO usuario){
        return usuario.toString() + " ¡REGISTRADO EXITOSAMENTE!";
    }
}

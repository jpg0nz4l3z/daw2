package org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.controller;

import jakarta.validation.Valid;
import org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.dto.UsuarioDTO;
import org.daw2.practicas_entorno_servidor.practica5sistemadeusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/todos")
    public List<UsuarioDTO> todos(){
        return usuarioService.obtenerTodos();
    }

    @PostMapping("/crear")
    public String crear(@Valid  @RequestBody UsuarioDTO usuario){
        return usuarioService.registrarUsuario(usuario);
    }
}

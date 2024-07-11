package com.service.users.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.authservice.dto.UsuarioTableDTO;
import com.service.users.authservice.service.UsuarioTableService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioTableController {

    @Autowired
    private UsuarioTableService usuarioTableService;

    @GetMapping
    public ResponseEntity<List<UsuarioTableDTO>> obtenerUsuarios() {
        List<UsuarioTableDTO> usuarios = usuarioTableService.obtenerTodosLosUsuariosConStatusUno();
        return ResponseEntity.ok(usuarios);
    }
}

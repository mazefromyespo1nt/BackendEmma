package com.service.users.authservice.controller;

import com.service.users.authservice.dto.UsuarioUpdateDTO;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.service.UsuarioUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioUpdateController {

    @Autowired
    private UsuarioUpdateService usuarioUpdateService;

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarUsuario(
        @PathVariable Integer id,
        @Valid @RequestBody UsuarioUpdateDTO usuarioUpdateDTO
    ) {
        try {
            Usuarios usuarioActualizado = usuarioUpdateService.actualizarUsuario(id, usuarioUpdateDTO);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


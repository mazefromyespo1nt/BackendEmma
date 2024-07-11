package com.service.users.authservice.controller;

import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.exception.UsuarioException;
import com.service.users.authservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioDemoController {

    @Autowired
    private UsuarioService userService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registerUser(@RequestBody Usuarios user) {
        try {
            Usuarios registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (UsuarioException e) {
            return new ResponseEntity<>("El correo electrónico ya está registrado", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario", HttpStatus.BAD_REQUEST);
        }
    }
}

package com.service.users.authservice.controller;

import com.service.users.authservice.dto.UsuarioLoginDTO;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.exception.UsuarioException;
import com.service.users.authservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginDemoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO loginRequest) {
        try {
            Usuarios usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsuarioException.EmailNotFoundException("El email no está registrado"));

            if (!usuario.getPassword().equals(loginRequest.getPassword())) {
                throw new UsuarioException.InvalidPasswordException("La contraseña es incorrecta");
            }

            // Simulación de generación de token
            String token = "token_de_ejemplo";

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Login exitoso");
            responseBody.put("token", token);

            return ResponseEntity.ok(responseBody);
        } catch (UsuarioException.EmailNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Email no encontrado", "message", ex.getMessage()));
        } catch (UsuarioException.InvalidPasswordException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Contraseña incorrecta", "message", ex.getMessage()));
        }
    }
}

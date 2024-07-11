package com.service.users.authservice.service;

import com.service.users.authservice.dto.UsuarioLoginDTO;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.exception.UsuarioException;
import com.service.users.authservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioLoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String login(UsuarioLoginDTO loginRequest) {
        Usuarios usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsuarioException.EmailNotFoundException("El email no está registrado"));

        if (!usuario.getPassword().equals(loginRequest.getPassword())) {
            throw new UsuarioException.InvalidPasswordException("La contraseña es incorrecta");
        }

        // Simulación de generación de token
        return generateSimpleToken(usuario);
    }

    private String generateSimpleToken(Usuarios usuario) {
        // Genera un token único para la sesión 
        return UUID.randomUUID().toString();
    }
}

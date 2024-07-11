package com.service.users.authservice.service;

import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.exception.UsuarioException;
import com.service.users.authservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios registerUser(Usuarios user) throws UsuarioException {
        Optional<Usuarios> existingUser = usuarioRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new UsuarioException("El correo electrónico ya está registrado");
        }

        return usuarioRepository.save(user);
    }
}

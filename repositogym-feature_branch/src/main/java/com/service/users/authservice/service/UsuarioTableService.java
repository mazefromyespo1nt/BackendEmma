package com.service.users.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.users.authservice.dto.UsuarioTableDTO;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioTableService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioTableDTO>obtenerTodosLosUsuariosConStatusUno() {
        List<Usuarios> usuarios = usuarioRepository.findByStatus(true);
        return usuarios.stream()
            .map(usuario -> new UsuarioTableDTO(
            	usuario.getIdUsuario(),	
                usuario.getNombre(),
                usuario.getLastname(),
                usuario.getEmail(),
                usuario.getFecha(),
                usuario.getTelefono()
            ))
            .collect(Collectors.toList());
    }
}

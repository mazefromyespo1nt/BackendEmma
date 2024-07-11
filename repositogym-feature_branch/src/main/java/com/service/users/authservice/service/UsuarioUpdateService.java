package com.service.users.authservice.service;

import com.service.users.authservice.dto.UsuarioUpdateDTO;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUpdateService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios actualizarUsuario(Integer id, UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuarios usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

    
        if (usuarioUpdateDTO.getNombre() != null) usuarioExistente.setNombre(usuarioUpdateDTO.getNombre());
        if (usuarioUpdateDTO.getApellido() != null) usuarioExistente.setLastname(usuarioUpdateDTO.getApellido());
        if (usuarioUpdateDTO.getEmail() != null) usuarioExistente.setEmail(usuarioUpdateDTO.getEmail());
        if (usuarioUpdateDTO.getFechaNacimiento() != null) usuarioExistente.setFecha(usuarioUpdateDTO.getFechaNacimiento());
        if (usuarioUpdateDTO.getTelefono() != null) usuarioExistente.setTelefono(usuarioUpdateDTO.getTelefono());

        
        return usuarioRepository.save(usuarioExistente);
    }
}

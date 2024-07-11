package com.service.users.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.users.authservice.entity.Usuarios;
import com.service.users.authservice.repository.UsuarioRepository;

import java.util.List;

@Service
public class DeleteStatusService {

    @Autowired
    private UsuarioRepository usuarioUpdateRepository;

    public int cambiarStatusAFalse(List<Integer> idsUsuarios) {
        List<Usuarios> usuarios = usuarioUpdateRepository.findAllById(idsUsuarios);
        int updatedCount = 0;
        for (Usuarios usuario : usuarios) {
            usuario.setStatus(false);
            updatedCount++;
        }
        usuarioUpdateRepository.saveAll(usuarios);
        return updatedCount;
    }
}

package com.service.users.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.users.authservice.entity.usuarios;
import com.service.users.authservice.repository.usuarioRepository;

@Service
public class usuarioServiceIMPLE implements usuarioService{
	
	@Autowired
	private usuarioRepository repository;

	@Override
	public void insetarUsuario(usuarios obj) {
		repository.save(obj);
	
		
	}

}

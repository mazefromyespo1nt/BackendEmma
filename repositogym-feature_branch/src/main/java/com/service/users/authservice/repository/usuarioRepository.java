package com.service.users.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.users.authservice.entity.usuarios;

public interface usuarioRepository extends JpaRepository<usuarios, Integer>{


}

package com.service.users.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.users.authservice.service.DeleteStatusService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class DeleteStatusController {

    @Autowired
    private DeleteStatusService DeleteStatusService;


    @PostMapping("/status/false")
    public ResponseEntity<String> cambiarStatusAFalse(@RequestBody List<Integer> idsUsuarios) {
        int updatedCount = DeleteStatusService.cambiarStatusAFalse(idsUsuarios);
        if (updatedCount > 0) {
            return ResponseEntity.ok("El estado de " + updatedCount + " usuario(s) ha sido actualizado a false.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios para actualizar.");
        }
    }
}

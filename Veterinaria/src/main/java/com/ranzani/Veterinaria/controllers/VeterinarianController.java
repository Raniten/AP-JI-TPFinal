package com.ranzani.Veterinaria.controllers;

import com.ranzani.Veterinaria.entities.Veterinarian;
import com.ranzani.Veterinaria.entities.dtos.VetDto;
import com.ranzani.Veterinaria.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VeterinarianController {

    @Autowired
    private final VeterinarianService veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    //OBTENER la lista de TODOS los veterinarios (GET)
    @GetMapping
    public ResponseEntity<List<Veterinarian>> getVets(){
        return ResponseEntity.status(HttpStatus.OK).body(veterinarianService.getVets());
    }

    //OBTENER UN SOLO veterinario por su ID (GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVisitById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(veterinarianService.getVetById(id));
    }

    //CREAR UN SOLO veterinario (POST)
    @PostMapping
    public ResponseEntity<VetDto> addVet(@RequestBody VetDto vet){
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarianService.addVet(vet));
    }
}

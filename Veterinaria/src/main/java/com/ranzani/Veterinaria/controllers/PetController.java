package com.ranzani.Veterinaria.controllers;

import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.dtos.PetDto;
import com.ranzani.Veterinaria.entities.dtos.UserDto;
import com.ranzani.Veterinaria.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    //OBTENER la lista de TODOS los pets (GET)
    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();

    }

    //OBTENER UN SOLO pet por su ID (GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetById(id));
    }

    //CREAR UN SOLO pet (POST)
    @PostMapping
    public Pet createPet(@RequestBody PetDto newPet) {
        return petService.addPet(newPet);
    }
}

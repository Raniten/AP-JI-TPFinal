package com.ranzani.Veterinaria.services;

import com.ranzani.Veterinaria.entities.Veterinarian;
import com.ranzani.Veterinaria.entities.dtos.VetDto;
import com.ranzani.Veterinaria.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeterinarianService {

    @Autowired
    private final VeterinarianRepository veterinarianRepository;


    public VeterinarianService(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    // * * * * * * * * * * * * * * * * * * * * * * *
    // M É T O D O S
    // * * * * * * * * * * * * * * * * * * * * * * *

    public List<Veterinarian> getVets() {
        return veterinarianRepository.findAll();
    }

    public ResponseEntity<?> getVetById(Long id) {
        return veterinarianRepository.findById(id)
                .map(veterinarian -> ResponseEntity.ok(veterinarian))  // Usuario encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Veterinarian(id, "Veterinario no encontrado", new ArrayList<>())));
    }

    public VetDto addVet(VetDto requestVet) {
        Veterinarian vet = new Veterinarian();
        vet.setIdVeterinarian(requestVet.getIdUserDto());
        vet.setName(requestVet.getName());

        veterinarianRepository.save(vet);
        return new VetDto(vet.getIdVeterinarian(), vet.getName(), requestVet.getVisits());
    }
}

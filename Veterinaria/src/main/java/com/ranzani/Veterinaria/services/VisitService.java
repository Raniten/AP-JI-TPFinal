package com.ranzani.Veterinaria.services;

import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.Veterinarian;
import com.ranzani.Veterinaria.entities.Visit;
import com.ranzani.Veterinaria.entities.dtos.VisitDto;
import com.ranzani.Veterinaria.repositories.PetRepository;
import com.ranzani.Veterinaria.repositories.VeterinarianRepository;
import com.ranzani.Veterinaria.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    private final VisitRepository visitRepository;

    @Autowired
    private final PetRepository petRepository;

    @Autowired
    private final VeterinarianRepository veterinarianRepository;


    public VisitService(VisitRepository visitRepository, PetRepository petRepository, VeterinarianRepository veterinarianRepository) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.veterinarianRepository = veterinarianRepository;
    }

    // * * * * * * * * * * * * * * * * * * * * * * *
    // M É T O D O S
    // * * * * * * * * * * * * * * * * * * * * * * *

    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    public ResponseEntity<?> getVisitById(Long id) {
        return visitRepository.findById(id)
                .map(visit -> ResponseEntity.ok(visit))  // Turno encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Visit(id, LocalDateTime.now(), /*new RequestedState(), */new Pet(null, "Turno no encontrado", new User(), new ArrayList<>()), new Veterinarian())));
    }

    public VisitDto addVisit(VisitDto requestVisit) {
        Visit visit = new Visit();

        if (petRepository.existsById(requestVisit.getPet())) {
            Pet pet = petRepository.findById(requestVisit.getPet()).get();
            visit.setPet(pet);
            visit.setVisit(requestVisit.getVisit());

        }
        visit.setIdVisit(requestVisit.getIdVisitDto());
        visit.setVisit(requestVisit.getVisit());
        visit.setPet(petRepository.findById(requestVisit.getPet()).get());

        visitRepository.save(visit);
        return new VisitDto(visit.getIdVisit(), visit.getVisit(), visit.getPet().getIdPet());
    }

    public List<Visit> getVisitsUnassigned() {

        List<Visit> visitsUnassigned = visitRepository.findAll().stream()
                .filter(visit -> visit.getVeterinarian() == null)
                .toList();
        return visitsUnassigned;
    }

    public ResponseEntity<?> assignVetToVisit(Long idVisit, Long idVeterinarian) {
        Visit visit = new Visit();
        Veterinarian vet = new Veterinarian();

        if(visitRepository.existsById(idVisit)) {
            if(veterinarianRepository.existsById(idVeterinarian)) {
                visit = visitRepository.findById(idVisit).get();
                vet = veterinarianRepository.findById(idVeterinarian).get();
                visit.setVeterinarian(vet);
            }
        }
        visitRepository.save(visit);
        return ResponseEntity.status(HttpStatus.OK).body("Veterinarian assigned successfully");
    }



}

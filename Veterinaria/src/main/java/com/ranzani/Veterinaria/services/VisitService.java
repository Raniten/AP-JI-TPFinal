package com.ranzani.Veterinaria.services;

import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.Veterinarian;
import com.ranzani.Veterinaria.entities.Visit;
import com.ranzani.Veterinaria.entities.dtos.VisitDto;
import com.ranzani.Veterinaria.entities.enums.VisitState;
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
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Visit(id, LocalDateTime.now(), new Pet(null, "Turno no encontrado", new User(), new ArrayList<>()), new Veterinarian())));
    }

    public ResponseEntity<VisitDto> addVisit(VisitDto requestVisit) {
        Visit visit = new Visit();

        if (petRepository.existsById(requestVisit.getPet())) {
            Pet pet = petRepository.findById(requestVisit.getPet()).get();
            visit.setPet(pet);
            visit.setVisit(requestVisit.getVisit());
            visit.setState(VisitState.NEW);
            visitRepository.save(visit);
            return ResponseEntity.status(HttpStatus.CREATED).body(new VisitDto(visit.getIdVisit(), visit.getVisit(), visit.getPet().getIdPet(), visit.getState().toString()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VisitDto());
        }
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

    public ResponseEntity<?> changeStateToVisit (Long idVisit, int newState) {
        Visit visit = new Visit();
        if( (newState+1) > VisitState.values().length) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid state: " + newState);
        } else {
            if(visitRepository.existsById(idVisit)) {
                visit = visitRepository.findById(idVisit).get();
                if (!VisitState.isAllowedState(visit.getState(), VisitState.values()[newState])) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid state transition: " + visit.getState() + " -> " + VisitState.values()[newState]);
                } else {
                    visit.changeState(VisitState.values()[newState]);
                    visitRepository.save(visit);
                    return ResponseEntity.status(HttpStatus.OK).build();
                }

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visit with id " + idVisit + " not found");
            }
        }
    }

    public ResponseEntity<?> getActiveVisit() {
        List<VisitState> states = List.of(new VisitState[]{VisitState.NEW, VisitState.RESCHEDULED});
        List<Visit> activeVisits = visitRepository.findByStateIn(states);
        if (activeVisits.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(activeVisits);
        }
    }

    /*public ResponseEntity<?> getVisitByPetId(Long idPet) {

        if (petRepository.existsById(idPet)) {
            List<Visit> petVisits = visitRepository.findByPetId(idPet);
            if (petVisits.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(petVisits);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet with id " + idPet + " not found");
        }
    }*/


}

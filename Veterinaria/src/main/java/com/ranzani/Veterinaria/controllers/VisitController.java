package com.ranzani.Veterinaria.controllers;

import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.Visit;
import com.ranzani.Veterinaria.entities.dtos.UserDto;
import com.ranzani.Veterinaria.entities.dtos.VisitDto;
import com.ranzani.Veterinaria.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    //OBTENER la lista de TODOS los turnos (GET)
    @GetMapping
    public ResponseEntity<List<Visit>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(visitService.getVisits());
    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVisitById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(visitService.getVisitById(id));
    }

    //CREAR UN SOLO turno (POST)
    @PostMapping
    public ResponseEntity<VisitDto> addVisit(@RequestBody VisitDto visit){
        return ResponseEntity.status(HttpStatus.CREATED).body(visitService.addVisit(visit));
    }
}

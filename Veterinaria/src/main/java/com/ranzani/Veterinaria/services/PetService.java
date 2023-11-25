package com.ranzani.Veterinaria.services;

import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.dtos.PetDto;
import com.ranzani.Veterinaria.entities.enums.CatBreed;
import com.ranzani.Veterinaria.entities.enums.DogBreed;
import com.ranzani.Veterinaria.entities.factories.CatFactory;
import com.ranzani.Veterinaria.entities.factories.DogFactory;
import com.ranzani.Veterinaria.repositories.PetRepository;
import com.ranzani.Veterinaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private final PetRepository petRepository;

    @Autowired
    private final UserRepository userRepository;

    public PetService(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    // * * * * * * * * * * * * * * * * * * * * * * *
    // M É T O D O S
    // * * * * * * * * * * * * * * * * * * * * * * *

    public List<Pet> getPets() {
        return petRepository.findAll();
    }


    public ResponseEntity<?> getPetById(Long id) {
        return petRepository.findById(id)
                .map(pet -> ResponseEntity.ok(pet))  // Pet encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Pet(id, "Pet no encontrada", new User(), new ArrayList<>())));
    }


    public Pet addPet(PetDto requestPet) {
        Pet pet = new Pet();
        if (userRepository.existsById(requestPet.getIdUser())) {
            User user = userRepository.findById(requestPet.getIdUser()).get();
            //pet.setIdPet(requestPet.getIdPet());
            //pet.setName(requestPet.getName());
            //pet.setUser(user);
            if (requestPet.getPetType().equalsIgnoreCase("CAT")) {
                CatFactory catFactory = new CatFactory((CatBreed.values()[requestPet.getBreed()-1]));
                pet = catFactory.createPet(user, requestPet.getName());

            }
            petRepository.save(pet);

        }
        return pet;

    }
}

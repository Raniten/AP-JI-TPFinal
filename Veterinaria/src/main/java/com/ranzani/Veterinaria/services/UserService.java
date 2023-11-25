package com.ranzani.Veterinaria.services;

import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.dtos.PetDto;
import com.ranzani.Veterinaria.entities.dtos.UserDto;
import com.ranzani.Veterinaria.entities.enums.CatBreed;
import com.ranzani.Veterinaria.entities.enums.DogBreed;
import com.ranzani.Veterinaria.entities.factories.CatFactory;
import com.ranzani.Veterinaria.entities.factories.DogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ranzani.Veterinaria.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // * * * * * * * * * * * * * * * * * * * * * * *
    // M É T O D O S
    // * * * * * * * * * * * * * * * * * * * * * * *

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public ResponseEntity<?> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(user))  // Usuario encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User(id, "Usuario no encontrado", "", new ArrayList<>())));
    }

    public UserDto addUser(UserDto requestUser) {
        User user = new User();
        user.setIdUser(requestUser.getIdUserDto());
        user.setNames(requestUser.getNames());
        user.setSurName(requestUser.getSurName());

        for (PetDto petRequest : requestUser.getPets()) {
            int breed = petRequest.getBreed();
            if (petRequest.getPetType().equalsIgnoreCase("CAT")) {
                user.addPet(new CatFactory(CatBreed.values()[breed-1]), petRequest.getName());
            } else if (petRequest.getPetType().equalsIgnoreCase("DOG")) {
                user.addPet(new DogFactory(DogBreed.values()[breed-1]), petRequest.getName());
            }
        }
        userRepository.save(user);
        return new UserDto(user.getIdUser(), user.getNames(), user.getSurName(), requestUser.getPets());
    }
}

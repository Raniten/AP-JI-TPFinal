package com.ranzani.Veterinaria.controllers;

import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.dtos.UserDto;
import com.ranzani.Veterinaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //OBTENER la lista de TODOS los usuarios (GET)
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    //CREAR UN SOLO usario (POST)
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    //ELIMINAR un usuario (DELETE)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

}

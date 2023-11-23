package com.ranzani.Veterinaria.controllers;

import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.dtos.UserDto;
import com.ranzani.Veterinaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<User> getUsers() {
        return userService.getUsers();

    }

    //OBTENER UN SOLO usuario por su ID (GET)
    @GetMapping(value="/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //CREAR UN SOLO usario (POST)
    @PostMapping
    public User createUser(@RequestBody UserDto newUser) {

        return userService.addUser(newUser);
    }


}

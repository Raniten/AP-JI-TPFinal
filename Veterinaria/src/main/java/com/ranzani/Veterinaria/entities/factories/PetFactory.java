package com.ranzani.Veterinaria.entities.factories;

import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;

public interface PetFactory {
    Pet createPet(User user, String name);

}
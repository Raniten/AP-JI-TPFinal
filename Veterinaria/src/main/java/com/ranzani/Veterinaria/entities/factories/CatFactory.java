package com.ranzani.Veterinaria.entities.factories;

import com.ranzani.Veterinaria.entities.Cat;
import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.enums.CatBreed;

public class CatFactory implements PetFactory{

    private final CatBreed catBreed;


    public CatFactory(CatBreed catBreed) {
        this.catBreed = catBreed;
    }

    @Override
    public Pet createPet(User user, String name) {
        return new Cat(name, user, this.catBreed);
    }

}

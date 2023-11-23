package com.ranzani.Veterinaria.entities.factories;

import com.ranzani.Veterinaria.entities.Dog;
import com.ranzani.Veterinaria.entities.Pet;
import com.ranzani.Veterinaria.entities.User;
import com.ranzani.Veterinaria.entities.enums.DogBreed;

public class DogFactory implements PetFactory{

    private final DogBreed dogBreed;


    public DogFactory(DogBreed dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public Pet createPet(User user, String name) {
        return new Dog(name, user, this.dogBreed);
    }

}

package com.ranzani.Veterinaria.entities;

import com.ranzani.Veterinaria.entities.enums.DogBreed;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("DOG")
public class Dog extends Pet {
    private DogBreed dogBreed;

    public Dog(String name, User user, DogBreed dogBreed) {
        super(null, name, user, new ArrayList<>());
        this.dogBreed = dogBreed;
    }

}

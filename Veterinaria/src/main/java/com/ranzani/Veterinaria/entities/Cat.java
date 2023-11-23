package com.ranzani.Veterinaria.entities;

import com.ranzani.Veterinaria.entities.enums.CatBreed;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CAT")

public class Cat extends Pet {
    private CatBreed catBreed;

    public Cat(String name, User user, CatBreed catBreed) {
        super(null, name, user);
        this.catBreed = catBreed;
    }
}


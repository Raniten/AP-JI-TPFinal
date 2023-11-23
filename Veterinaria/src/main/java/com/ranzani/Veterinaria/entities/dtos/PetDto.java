package com.ranzani.Veterinaria.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PetDto {
    private String petType;
    private String name;
    private int breed;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raniten.vetmdr.entities;

/**
 *
 * @author Marcelo
 */
public class DogFactory implements PetFactory{
    
    private DogBreed dogBreed;
    
    public DogFactory(DogBreed DogBreed) {
        this.dogBreed = dogBreed;
    }
    
    @Override
    public Pet createPet(User user, String name) {
        return new Dog(name, user, this.dogBreed);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raniten.vetmdr.entities;

/**
 *
 * @author Marcelo
 */
public class CatFactory implements PetFactory{
    
    private CatBreed catBreed;
    
    public CatFactory(CatBreed catBreed) {
        this.catBreed = catBreed;
    }
    
    @Override
    public Pet createPet(User user, String name) {
        return new Cat(name, user, this.catBreed);
    }
    
}

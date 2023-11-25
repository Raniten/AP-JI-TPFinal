package com.raniten.vetmdr.entities;

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

package com.raniten.vetmdr.repositories;

import com.raniten.vetmdr.controllers.PetController;
import com.raniten.vetmdr.entities.Pet;
import com.raniten.vetmdr.entities.PetDAO;
import java.util.List;


public class PetRepository implements PetDAO{
    
    public PetController petController;
    
    public PetRepository() {
        this.petController = new PetController();
    }
    
    @Override
    public Pet obtenerPorId(Long id) {
        return petController.findPet(id);
    }

    @Override
    public List<Pet> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardar(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

package com.raniten.vetmdr.entities;

import java.util.List;

public interface PetDAO {
    
    Pet obtenerPorId(Long id);
    List<Pet> obtenerTodos();
    void guardar(Pet pet);
    void actualizar(Pet pet);
    void eliminar(Long id);
    
}

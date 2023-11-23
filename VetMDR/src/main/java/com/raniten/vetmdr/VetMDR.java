/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.raniten.vetmdr;

import com.raniten.vetmdr.entities.CatBreed;
import com.raniten.vetmdr.entities.CatFactory;
import com.raniten.vetmdr.entities.DogBreed;
import com.raniten.vetmdr.entities.DogFactory;
import com.raniten.vetmdr.entities.Pet;
import com.raniten.vetmdr.entities.PetFactory;
import com.raniten.vetmdr.entities.PetType;
import com.raniten.vetmdr.entities.User;
import com.raniten.vetmdr.entities.UserDAO;
import com.raniten.vetmdr.entities.dtos.PetDto;
import com.raniten.vetmdr.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class VetMDR {

    public static void main(String[] args) {
        
        User user = new User(null, "Nombre 1", "Apellido 1", new ArrayList<Pet>());
        
        CatFactory catFactory = new CatFactory(CatBreed.PERSA);
        
        DogFactory dogFactory = new DogFactory(DogBreed.CHIHUAHUA);
        
        Pet cat = catFactory.createPet(user, "Gaturro");
        Pet dog = dogFactory.createPet(user, "Colita");
        
        UserDAO userDao = new UserRepository();
        
        userDao.guardar(user);
        
    }
}

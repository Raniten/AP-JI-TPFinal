package com.raniten.vetmdr.repositories;

import com.raniten.vetmdr.controllers.PetController;
import com.raniten.vetmdr.controllers.UserController;
import com.raniten.vetmdr.entities.Pet;
import com.raniten.vetmdr.entities.User;
import com.raniten.vetmdr.entities.UserDAO;
import java.util.List;

public class UserRepository implements UserDAO{
    
    public UserController userController;
    
    public UserRepository() {
        this.userController = new UserController();
    }
    
    @Override
    public User obtenerPorId(Long id) {
        return userController.findUser(id);
    }

    @Override
    public List<User> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void guardar(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizar(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

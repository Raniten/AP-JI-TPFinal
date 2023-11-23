package com.raniten.vetmdr.entities;

import java.util.List;

public interface UserDAO {
    
    User obtenerPorId(Long id);
    List<User> obtenerTodos();
    void guardar(User user);
    void actualizar(User user);
    void eliminar(Long id);
    
}

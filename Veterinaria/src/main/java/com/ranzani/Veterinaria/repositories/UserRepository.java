package com.ranzani.Veterinaria.repositories;

import com.ranzani.Veterinaria.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}

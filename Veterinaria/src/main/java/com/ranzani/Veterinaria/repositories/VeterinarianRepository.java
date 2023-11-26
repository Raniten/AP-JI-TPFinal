package com.ranzani.Veterinaria.repositories;

import com.ranzani.Veterinaria.entities.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}

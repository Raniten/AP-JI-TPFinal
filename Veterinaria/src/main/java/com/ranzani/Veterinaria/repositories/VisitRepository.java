package com.ranzani.Veterinaria.repositories;

import com.ranzani.Veterinaria.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository <Visit, Long> {
}

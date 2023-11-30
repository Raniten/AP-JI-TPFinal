package com.ranzani.Veterinaria.repositories;

import com.ranzani.Veterinaria.entities.Visit;
import com.ranzani.Veterinaria.entities.enums.VisitState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository <Visit, Long> {
    List<Visit> findByStateIn(List<VisitState> states);

    //List<Visit> findByPetId(Long id);
}

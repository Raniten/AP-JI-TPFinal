package com.ranzani.Veterinaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisit;
    private LocalDateTime visit;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}

package com.ranzani.Veterinaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="veterinarians")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeterinarian;

    private String name;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();
}

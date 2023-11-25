package com.ranzani.Veterinaria.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {
    private Long idVisitDto;
    private LocalDateTime visit;
    private Long pet;

}
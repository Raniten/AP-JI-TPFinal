package com.ranzani.Veterinaria.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VetDto {
    private Long idUserDto;
    private String name;
    private List<VisitDto> visits;
}

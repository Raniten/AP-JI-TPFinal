package com.raniten.vetmdr.entities.dtos;

import com.raniten.vetmdr.entities.PetType;
import com.raniten.vetmdr.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PetDto {
    private PetType petType;
    private Long idPetDto;
    private String name;
    private User user;
    
    public PetDto (PetType petType, Long idPetDto, String name, User user, )
    
    
}

package com.ranzani.Veterinaria.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVisit")


public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisit;
    private LocalDateTime visit;


    //private VisitState<Visit> state;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="veterinarian_id")
    private Veterinarian veterinarian;

    /*public Visit(LocalDateTime visit) {
        this.visit = visit;
        this.state = new RequestedState();
    }

    public void requestVisit() {
        state.requestVisit(this);
    }

    public void cancelVisit() {
        state.cancelVisit(this);
    }

    public void completeVisit() {
        state.completeVisit(this);
    }

    public void rescheduleVisit() {
        state.rescheduleVisit(this);
    }*/

}

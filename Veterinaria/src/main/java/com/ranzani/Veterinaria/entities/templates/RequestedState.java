package com.ranzani.Veterinaria.entities.templates;

import com.ranzani.Veterinaria.entities.Visit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RequestedState implements VisitState<Visit> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public void requestVisit(Visit visit) {
        System.out.println("Visit has already been requested.");
    }

    @Override
    public void cancelVisit(Visit visit) {
        //visit.setState(new CanceledState());
        System.out.println("Visit canceled successfully.");
    }

    @Override
    public void completeVisit(Visit visit) {
        //visit.setState(new CompletedState());
        System.out.println("Visit completed successfully.");
    }

    @Override
    public void rescheduleVisit(Visit visit) {
        //visit.setState(new RescheduledState());
        System.out.println("Visit rescheduled successfully.");
    }
}

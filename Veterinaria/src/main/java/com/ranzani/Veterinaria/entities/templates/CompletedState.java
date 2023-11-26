package com.ranzani.Veterinaria.entities.templates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompletedState implements VisitState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public void requestVisit(Object visit) {
        System.out.println("Cannot request a completed visit.");
    }

    @Override
    public void cancelVisit(Object visit) {
        System.out.println("Cannot cancel a completed visit.");
    }

    @Override
    public void completeVisit(Object visit) {
        System.out.println("Visit is already completed.");
    }

    @Override
    public void rescheduleVisit(Object visit) {
        System.out.println("Cannot reschedule a completed visit.");
    }
}

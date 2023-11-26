package com.ranzani.Veterinaria.entities.templates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RescheduledState implements VisitState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public void requestVisit(Object visit) {
        System.out.println("Cannot request a canceled visit.");
    }

    @Override
    public void cancelVisit(Object visit) {
        System.out.println("Visit is already canceled.");
    }

    @Override
    public void completeVisit(Object visit) {
        System.out.println("Cannot complete a canceled visit.");
    }

    @Override
    public void rescheduleVisit(Object visit) {
        System.out.println("Cannot reschedule a canceled visit.");
    }
}

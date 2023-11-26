package com.ranzani.Veterinaria.entities.templates;

import jakarta.persistence.MappedSuperclass;

//@Enumerated(EnumType.STRING)
@MappedSuperclass
public interface VisitState <Visit> {
    void requestVisit(Visit visit);
    void cancelVisit(Visit visit);
    void completeVisit(Visit visit);
    void rescheduleVisit(Visit visit);
}

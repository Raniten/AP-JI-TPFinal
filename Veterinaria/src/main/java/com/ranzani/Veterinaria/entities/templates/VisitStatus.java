package com.ranzani.Veterinaria.entities.templates;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter

public class VisitStatus {

    private VisitState state;
    private LocalDateTime rescheduledDate;
    private boolean assigned;

    public VisitStatus(VisitState state) {
        this.state = state;
        this.assigned = false;
    }

    public VisitState getState() {
        return state;
    }

    public void setState(VisitState state) {
        this.state = state;
    }

    public LocalDateTime getRescheduledDate() {
        return rescheduledDate;
    }

    public void setRescheduledDate(LocalDateTime rescheduledDate) {
        this.rescheduledDate = rescheduledDate;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}

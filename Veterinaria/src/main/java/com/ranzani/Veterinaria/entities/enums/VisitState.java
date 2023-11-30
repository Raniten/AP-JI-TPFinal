package com.ranzani.Veterinaria.entities.enums;

import java.util.Map;
import java.util.Set;

public enum VisitState {
    NEW,
    CANCELED,
    RESCHEDULED,
    FINISHED;

    private static final Map<VisitState, Set<VisitState>> allowedStates = Map.of(
            NEW, Set.of(CANCELED, RESCHEDULED, FINISHED),
            CANCELED, Set.of(),
            RESCHEDULED, Set.of(CANCELED, FINISHED),
            FINISHED, Set.of()
    );

    public static boolean isAllowedState(VisitState visitState, VisitState newVisitState) {
        return allowedStates.get(visitState).contains(newVisitState);
    }
}

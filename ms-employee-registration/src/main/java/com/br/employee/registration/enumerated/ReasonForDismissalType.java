package com.br.employee.registration.enumerated;

import java.util.Optional;
import java.util.stream.Stream;

public enum ReasonForDismissalType {
    RESIGNATION,
    DISMISSAL_WITHOUT_CAUSE,
    DISMISSAL_WITH_CAUSE,
    END_OF_EXPERIENCE_CONTRACT;

    public static Optional<ReasonForDismissalType> fromName(String name){
        return Stream.of(values())
            .filter(type -> type.name().equals(name))
            .findFirst();
    }
}

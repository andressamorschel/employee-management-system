package com.br.employee.registration.enumerated;

import java.util.Optional;
import java.util.stream.Stream;

public enum GenderType {

    MALE,
    FEMALE;

    public static Optional<GenderType> fromName(String genderType) {
        return Stream.of(values())
            .filter(type -> type.name().equals(genderType))
            .findFirst();
    }

}

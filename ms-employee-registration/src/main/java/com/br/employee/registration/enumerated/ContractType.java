package com.br.employee.registration.enumerated;

import java.util.Optional;
import java.util.stream.Stream;

public enum ContractType {
    CLT,
    PJ,
    COOPERATED;

    public static Optional<ContractType> fromName(String contractType) {
        return Stream.of(values())
            .filter(type -> type.name().equals(contractType))
            .findFirst();
    }
}

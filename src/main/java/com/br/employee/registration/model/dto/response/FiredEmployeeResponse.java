package com.br.employee.registration.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.employee.registration.enumerated.ReasonForDismissalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiredEmployeeResponse {

    private String firedEmployeeId;

    private String name;

    private String occupation;

    private BigDecimal terminationAmount;

    private ReasonForDismissalType reasonForDismissal;

    private boolean fulfilledPriorNotice;

    private String document;

    private LocalDate shutdownDate;
}

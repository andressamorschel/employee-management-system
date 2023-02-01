package com.br.employee.registration.model.domain;

import com.br.employee.registration.enumerated.ReasonForDismissalType;
import com.br.employee.registration.model.dto.request.FiredEmployeeRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fired-employee")
public class FiredEmployeeDomain {

    @Id
    @Column(name = "fired_employee_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String firedEmployeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "termination_amount")
    private BigDecimal terminationAmount;

    @Column(name = "reason_for_dismissal")
    @Enumerated(EnumType.STRING)
    private ReasonForDismissalType reasonForDismissal;

    @Column(name = "fulfilled_prior_notice")
    private boolean fulfilledPriorNotice;

    @Column(name = "document")
    private String document;

    @Column(name = "shutdown_date")
    private LocalDate shutdownDate;

}

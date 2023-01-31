package com.br.employee.registration.service;

import com.br.employee.registration.enumerated.ReasonForDismissalType;
import com.br.employee.registration.exception.EmployeeNotFoundException;
import com.br.employee.registration.model.domain.EmployeeDomain;
import com.br.employee.registration.model.domain.FiredEmployeeDomain;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.br.employee.registration.model.dto.request.FiredEmployeeRequest;
import com.br.employee.registration.repository.EmployeeRepository;
import com.br.employee.registration.repository.FiredEmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FiredEmployeeService {

    private final EmployeeRepository employeeRepository;

    private final FiredEmployeeRepository firedEmployeeRepository;

    public void createFiredEmployee(String employeeId, FiredEmployeeRequest firedEmployeeRequest) {
        var employeeDomain = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        employeeRepository.delete(employeeDomain);
        // TODO -> criar microsserviço de ponto e verificar horas trabalhadas
        // TODO -> aplicar factory method para calcular rescisão
    }

    private FiredEmployeeDomain buildFiredEmployeeDomain(EmployeeDomain employeeDomain, FiredEmployeeRequest firedEmployeeRequest) {
        return FiredEmployeeDomain.builder()
                .fulfilledPriorNotice(firedEmployeeRequest.isFulfilledPriorNotice())
                .reasonForDismissal(ReasonForDismissalType.fromName(firedEmployeeRequest.getReasonForDismissal())
                        .orElse(null))
                .shutdownDate(firedEmployeeRequest.getShutdownDate())
                .document(employeeDomain.getDocument())
                .name(employeeDomain.getName())
                .occupation(employeeDomain.getOccupation())
                .terminationAmount(null)
                .build();
    }

    private BigDecimal calculateTerminationAmount(){
        return null;
    }
}

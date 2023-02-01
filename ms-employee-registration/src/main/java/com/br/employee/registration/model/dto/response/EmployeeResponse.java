package com.br.employee.registration.model.dto.response;

import com.br.employee.registration.enumerated.ContractType;
import com.br.employee.registration.enumerated.GenderType;
import com.br.employee.registration.model.domain.EmployeeDomain;
import com.br.employee.registration.model.dto.request.EmployeeRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.employee.registration.model.domain.AddressDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private String employeeId;

    private String name;

    private BigDecimal salary;

    private String gender;

    private String contractType;

    private String document;

    private String occupation;

    private LocalDate admissionDate;

    private LocalDate birthDate;

    private AddressDomain address;

    public static EmployeeResponse valueOf(EmployeeDomain employeeDomain){
        return EmployeeResponse.builder()
            .employeeId(employeeDomain.getEmployeeId())
            .salary(employeeDomain.getSalary())
            .address(employeeDomain.getAddress())
            .admissionDate(employeeDomain.getAdmissionDate())
            .birthDate(employeeDomain.getBirthDate())
            .contractType(employeeDomain.getContractType().name())
            .gender(employeeDomain.getGender().name())
            .occupation(employeeDomain.getOccupation())
            .document(employeeDomain.getDocument())
            .name(employeeDomain.getName())
            .build();
    }

}

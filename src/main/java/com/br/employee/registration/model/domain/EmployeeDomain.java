package com.br.employee.registration.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.br.employee.registration.enumerated.ContractType;
import com.br.employee.registration.enumerated.GenderType;
import com.br.employee.registration.model.dto.request.EmployeeRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class EmployeeDomain {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column(name = "contract_type")
    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Column(name = "document")
    private String document;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private AddressDomain address;

    public static EmployeeDomain valueOf(EmployeeRequest employeeRequest){
        return EmployeeDomain.builder()
            .salary(employeeRequest.getSalary())
            .address(AddressDomain.valueOf(employeeRequest.getAddress()))
            .admissionDate(employeeRequest.getAdmissionDate())
            .birthDate(employeeRequest.getBirthDate())
            .contractType(ContractType.fromName(employeeRequest.getContractType()).orElse(null))
            .gender(GenderType.fromName(employeeRequest.getGender()).orElse(null))
            .occupation(employeeRequest.getOccupation())
            .document(employeeRequest.getDocument())
            .name(employeeRequest.getName())
            .build();
    }

}

package com.br.control.hours.model.dto.response;

import com.br.control.hours.enumerated.ContractType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private String employeeId;

    private BigDecimal salary;

    private String document;

    private String name;

    private ContractType contractType;

    private String occupation;

}

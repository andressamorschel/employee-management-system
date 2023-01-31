package com.br.employee.registration.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @Size(max = 255)
    @NotBlank(message = "400.001")
    private String name;

    @NotNull(message = "400.002")
    private BigDecimal salary;

    @Size(max = 6)
    @NotBlank(message = "400.001")
    private String gender;

    @Size(max = 10)
    @NotBlank(message = "400.001")
    private String contractType;

    @Size(max = 11)
    @NotBlank(message = "400.001")
    private String document;

    @Size(max = 255)
    @NotBlank(message = "400.001")
    private String occupation;

    @NotNull(message = "400.002")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate admissionDate;

    @NotNull(message = "400.002")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;

    @NotNull(message = "400.002")
    private AddressRequest address;
}

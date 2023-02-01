package com.br.employee.registration.model.dto.request;

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
public class FiredEmployeeRequest {

    @Size(max = 30)
    @NotBlank(message = "400.001")
    private String reasonForDismissal;

    @NotNull(message = "400.002")
    private boolean fulfilledPriorNotice;
    @NotNull(message = "400.002")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate shutdownDate;
}

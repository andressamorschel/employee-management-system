package com.br.employee.registration.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @Size(max = 255, message = "400.001")
    private String street;

    @Size(max = 10, message = "400.001")
    private String number;

    @Size(max = 255, message = "400.001")
    private String city;

    @Size(max = 255, message = "400.001")
    private String neighborhood;

    @Size(max = 255, message = "400.001")
    private String state;

    @Size(max = 255, message = "400.001")
    private String country;
}

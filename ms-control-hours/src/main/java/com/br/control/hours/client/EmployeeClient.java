package com.br.control.hours.client;

import com.br.control.hours.model.dto.response.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(name = "ms-employee-registration", url = "http://localhost:8080", path = "/employee-registration/v1")
public interface EmployeeClient {

    @GetMapping("/{employeeId}")
    Optional<EmployeeResponse> findEmployeeById(@PathVariable String employeeId);
}

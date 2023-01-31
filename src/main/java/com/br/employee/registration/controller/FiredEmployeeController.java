package com.br.employee.registration.controller;

import com.br.employee.registration.model.dto.request.FiredEmployeeRequest;
import com.br.employee.registration.model.dto.response.FiredEmployeeResponse;
import com.br.employee.registration.service.FiredEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fired-employee")
@RequiredArgsConstructor
public class FiredEmployeeController {

    private final FiredEmployeeService firedEmployeeService;

    @PostMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public FiredEmployeeResponse createFiredEmployee(@PathVariable String employeeId, @RequestBody FiredEmployeeRequest firedEmployeeRequest) {
        return null;
    }
}

package com.br.employee.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.employee.registration.exception.EmployeeAlreadyExistException;
import com.br.employee.registration.exception.EmployeeNotFoundException;
import com.br.employee.registration.model.domain.EmployeeDomain;
import com.br.employee.registration.model.dto.request.EmployeeRequest;
import com.br.employee.registration.model.dto.response.EmployeeResponse;
import com.br.employee.registration.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        employeeRepository.findByName(employeeRequest.getName())
                .ifPresent((employeeDomain) -> {
                    throw new EmployeeAlreadyExistException("Employee already exist with id: " +
                            employeeDomain.getEmployeeId());
                });

        var employeeSaved = employeeRepository.save(EmployeeDomain.valueOf(employeeRequest));
        return EmployeeResponse.valueOf(employeeSaved);
    }

    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeResponse::valueOf)
                .toList();
    }

    public EmployeeResponse getEmployeeById(String employeeId) {
        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        return EmployeeResponse.valueOf(employee);
    }
}

package com.br.employee.registration.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.employee.registration.enumerated.ContractType;
import com.br.employee.registration.enumerated.GenderType;
import com.br.employee.registration.exception.EmployeeAlreadyExistException;
import com.br.employee.registration.exception.EmployeeNotFoundException;
import com.br.employee.registration.model.domain.AddressDomain;
import com.br.employee.registration.model.domain.EmployeeDomain;
import com.br.employee.registration.model.dto.request.AddressRequest;
import com.br.employee.registration.model.dto.request.EmployeeRequest;
import com.br.employee.registration.model.dto.response.EmployeeResponse;
import com.br.employee.registration.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeRequest employeeRequest;

    private EmployeeResponse employeeResponse;

    private List<EmployeeResponse> employees;

    private EmployeeDomain employeeDomain;

    private String employeeId;

    @Test
    void shouldCreateEmployeeSuccessfully() {
        givenValidEmployeeRequest();
        givenEmployeeRepositoryFindByNameReturnsEmpty();
        givenEmployeeRepositorySaveReturnsEmployeeDomain();
        whenCreateEmployeeCalled();
        thenExpectEmployeeResponseIsNotNull();
        thenExpectEmployeeRepositorySaveCalledOnce();
        thenExpectEmployeeRepositoryFindByNameCalledOnce();
    }

    @Test
    void shouldCreateEmployeeThrowsEmployeeAlreadyExistException() {
        givenValidEmployeeRequest();
        givenEmployeeRepositoryFindByNameReturnsEmployeeDomain();
        whenCreateEmployeeCalledThrowsEmployeeAlreadyExistException();
        thenExpectEmployeeRepositorySaveNotCalled();
        thenExpectEmployeeRepositoryFindByNameCalledOnce();
    }

    @Test
    void shouldGetEmployeesSuccessfully() {
        givenEmployeeDomain();
        givenEmployeeRepositoryFindAllReturnsEmpty();
        whenGetEmployeesCalled();
        thenExpectEmployeeRepositoryFindAllCalledOnce();
        thenExpectEmployeesResponseIsNotNull();
    }

    @Test
    void shouldGetEmployeeByIdSuccessfully() {
        givenEmployeeId();
        givenEmployeeRepositoryFindByIdReturnsEmployeeDomain();
        whenGetEmployeeByIdCalled();
        thenExpectEmployeeResponseIsNotNull();
        thenExpectEmployeeRepositoryFindByIdCalledOnce();
    }

    @Test
    void shouldGetEmployeeByIdThrowsEmployeeNotFoundException() {
        givenEmployeeId();
        givenEmployeeRepositoryFindByIdReturnsEmpty();
        whenGetEmployeesByIdCalledThrowsEmployeeNotFoundException();
        thenExpectEmployeeRepositoryFindByIdCalledOnce();
    }

    /**
     * Given methods
     */

    private void givenEmployeeId() {
        employeeId = "123";
    }

    private void givenValidEmployeeRequest() {
        AddressRequest addressRequest = AddressRequest.builder()
                .city("Campo Bom")
                .country("Brasil")
                .neighborhood("Imigrante")
                .street("Av Brasil")
                .number("404")
                .state("Rio Grande do Sul")
                .build();

        employeeRequest = EmployeeRequest.builder()
                .name("Andressa Morschel Urbano")
                .gender("FEMALE")
                .occupation("Backend developer")
                .salary(new BigDecimal(1000000))
                .birthDate(LocalDate.of(2003, 3, 6))
                .contractType("COOPERATED")
                .document("087528765434")
                .admissionDate(LocalDate.of(2023, 2, 6))
                .address(addressRequest)
                .build();
    }

    private void givenEmployeeRepositoryFindByNameReturnsEmpty() {
        doReturn(Optional.empty()).when(employeeRepository).findByName(anyString());
    }

    private void givenEmployeeRepositoryFindByIdReturnsEmployeeDomain() {
        givenEmployeeDomain();
        doReturn(Optional.of(employeeDomain)).when(employeeRepository).findById(anyString());
    }

    private void givenEmployeeRepositoryFindByIdReturnsEmpty() {
        doReturn(Optional.empty()).when(employeeRepository).findById(anyString());
    }

    private void givenEmployeeRepositoryFindAllReturnsEmpty() {
        doReturn(List.of(employeeDomain)).when(employeeRepository).findAll();
    }

    private void givenEmployeeRepositoryFindByNameReturnsEmployeeDomain() {
        doReturn(Optional.of(new EmployeeDomain())).when(employeeRepository).findByName(anyString());
    }

    private void givenEmployeeDomain(){
         employeeDomain = EmployeeDomain.builder()
            .employeeId("123")
            .salary(new BigDecimal(1000))
            .address(new AddressDomain())
            .admissionDate(LocalDate.of(2022, 1, 5))
            .birthDate(LocalDate.of(2003, 1, 6))
            .contractType(ContractType.COOPERATED)
            .gender(GenderType.FEMALE)
            .occupation("Developer")
            .document("23465598")
            .name("Andressa Morschel")
            .build();
    }

    private void givenEmployeeRepositorySaveReturnsEmployeeDomain() {
        givenEmployeeDomain();
        doReturn(employeeDomain).when(employeeRepository).save(any(EmployeeDomain.class));
    }

    /**
     * When methods
     */

    private void whenCreateEmployeeCalled() {
        employeeResponse = employeeService.createEmployee(employeeRequest);
    }

    private void whenCreateEmployeeCalledThrowsEmployeeAlreadyExistException() {
        assertThrows(EmployeeAlreadyExistException.class, () -> employeeService.createEmployee(employeeRequest));
    }

    private void whenGetEmployeesCalled() {
        employees = employeeService.getEmployees();
    }

    private void whenGetEmployeeByIdCalled() {
        employeeResponse = employeeService.getEmployeeById(employeeId);
    }

    private void whenGetEmployeesByIdCalledThrowsEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(employeeId));
    }

    /**
     * Then methods
     */

    private void thenExpectEmployeeResponseIsNotNull() {
        assertNotNull(employeeResponse);
    }

    private void thenExpectEmployeesResponseIsNotNull() {
        assertNotNull(employees);
    }

    private void thenExpectEmployeeRepositorySaveCalledOnce() {
        verify(employeeRepository).save(any(EmployeeDomain.class));
    }

    private void thenExpectEmployeeRepositoryFindByIdCalledOnce() {
        verify(employeeRepository).findById(anyString());
    }

    private void thenExpectEmployeeRepositorySaveNotCalled() {
        verify(employeeRepository, never()).save(any(EmployeeDomain.class));
    }

    private void thenExpectEmployeeRepositoryFindAllCalledOnce() {
        verify(employeeRepository).findAll();
    }

    private void thenExpectEmployeeRepositoryFindByNameCalledOnce() {
        verify(employeeRepository).findByName(anyString());
    }
}

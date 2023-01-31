package com.br.employee.registration.exception;

public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(String message){
        super(message);
    }
}

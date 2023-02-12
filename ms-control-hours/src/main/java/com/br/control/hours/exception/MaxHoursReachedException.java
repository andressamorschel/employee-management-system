package com.br.control.hours.exception;

public class MaxHoursReachedException extends RuntimeException {
    public MaxHoursReachedException(String message) {
        super(message);
    }
}

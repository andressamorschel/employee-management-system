package com.br.control.hours.controller;

import com.br.control.hours.service.RecordOfHourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RecordOfHourController {

    private final RecordOfHourService recordOfHourService;

    @PostMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createRecord(@PathVariable String employeeId){
        recordOfHourService.createRecord(employeeId);
    }
}

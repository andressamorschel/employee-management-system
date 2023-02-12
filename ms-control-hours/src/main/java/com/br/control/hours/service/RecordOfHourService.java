package com.br.control.hours.service;

import com.br.control.hours.client.EmployeeClient;
import com.br.control.hours.exception.EmployeeNotFoundException;
import com.br.control.hours.exception.MaxHoursReachedException;
import com.br.control.hours.model.domain.RecordOfHourDomain;
import com.br.control.hours.model.dto.response.EmployeeResponse;
import com.br.control.hours.repository.RecordOfHourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecordOfHourService {

    private final RecordOfHourRepository recordOfHourRepository;

    private final EmployeeClient employeeClient;

    public void createRecord(String employeeId) {
        var employee = findEmployeeById(employeeId);

        recordOfHourRepository.findByEmployeeId(employeeId)
                .ifPresent(this::addRecord);

        saveRecordOfHour(employee);
    }

    private EmployeeResponse findEmployeeById(String employeeId) {
        return employeeClient.findEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));
    }

    private void saveRecordOfHour(EmployeeResponse employeeResponse) {
        recordOfHourRepository.save(buildRecordDomain(employeeResponse.getEmployeeId()));
    }

    private void addRecord(RecordOfHourDomain recordOfHourDomain) {
        if(recordOfHourDomain.getHoursPosted().size() >= 4){
            throw new MaxHoursReachedException("The maximum number of records per day is four.");
        }

        recordOfHourDomain.getHoursPosted().add(LocalTime.now());
        recordOfHourRepository.save(recordOfHourDomain);
    }

    private RecordOfHourDomain buildRecordDomain(String employeeId) {
        TreeSet<LocalTime> recordsPosted = new TreeSet<>();
        recordsPosted.add(LocalTime.now());

        return RecordOfHourDomain.builder()
                .date(LocalDate.now())
                .recordOfHoursId(UUID.randomUUID().toString())
                .employeeId(employeeId)
                .hoursPosted(recordsPosted)
                .build();
    }
}

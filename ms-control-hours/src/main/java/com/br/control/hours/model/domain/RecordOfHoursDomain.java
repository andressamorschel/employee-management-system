package com.br.control.hours.model.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RecordOfHoursDomain {

    @Id
    private String id;

    @Indexed(unique = true)
    private String recordOfHoursId;

    private String employeeId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime endInterval;

    private LocalTime startInterval;
}

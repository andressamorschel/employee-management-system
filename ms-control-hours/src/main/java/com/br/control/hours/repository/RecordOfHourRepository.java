package com.br.control.hours.repository;

import com.br.control.hours.model.domain.RecordOfHourDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordOfHourRepository extends MongoRepository<RecordOfHourDomain, String> {

    Optional<RecordOfHourDomain> findByEmployeeId(String employeeId);
}

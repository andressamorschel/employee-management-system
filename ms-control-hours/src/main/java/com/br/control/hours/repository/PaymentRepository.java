package com.br.control.hours.repository;

import com.br.control.hours.model.domain.PaymentDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDomain, String> {
}

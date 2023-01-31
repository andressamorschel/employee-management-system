package com.br.employee.registration.repository;

import com.br.employee.registration.model.domain.FiredEmployeeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiredEmployeeRepository extends JpaRepository<FiredEmployeeDomain, String> {

}

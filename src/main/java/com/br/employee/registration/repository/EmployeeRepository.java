package com.br.employee.registration.repository;

import com.br.employee.registration.model.domain.EmployeeDomain;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDomain, String> {
    Optional<EmployeeDomain> findByName(String name);
}

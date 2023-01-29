package com.br.employee.registration.repository;

import com.br.employee.registration.model.domain.AddressDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDomain, String> {

}

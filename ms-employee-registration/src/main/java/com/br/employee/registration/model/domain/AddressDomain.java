package com.br.employee.registration.model.domain;

import com.br.employee.registration.model.dto.request.AddressRequest;
import com.br.employee.registration.model.dto.request.EmployeeRequest;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDomain {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String address_id;
    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    public static AddressDomain valueOf(AddressRequest addressRequest){
        return AddressDomain.builder()
            .city(addressRequest.getCity())
            .country(addressRequest.getCountry())
            .state(addressRequest.getState())
            .state(addressRequest.getState())
            .number(addressRequest.getNumber())
            .street(addressRequest.getStreet())
            .neighborhood(addressRequest.getNeighborhood())
            .build();
    }

}

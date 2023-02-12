package com.br.control.hours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsControlHoursPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsControlHoursPaymentsApplication.class, args);
	}

}

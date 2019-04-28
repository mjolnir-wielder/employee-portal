package com.mjolnir.employeeportal.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mjolnir.employeeportal")
public class EmployeePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class);
	}

}

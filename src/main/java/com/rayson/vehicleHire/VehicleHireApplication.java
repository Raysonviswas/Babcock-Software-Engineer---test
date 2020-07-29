package com.rayson.vehicleHire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VehicleHireApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleHireApplication.class, args);
	}

}

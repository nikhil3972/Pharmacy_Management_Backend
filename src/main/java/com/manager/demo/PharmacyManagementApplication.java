
package com.manager.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The PharmacyManagementApplication class is the main entry point of the Spring Boot application for the pharmacy management system.
 * @author Meghraj
 * @since 2023
 * @version 
 */
@SpringBootApplication
@RestController
public class PharmacyManagementApplication {
	
	/**
	 * Returns a welcome message to confirm the Spring Boot backend is running on Docker.
	 * @return A string containing the welcome message.
	 */
	@GetMapping("/welcome")
	public String welcome() {
		return "Springboot Backend Docker";
	}

	/**
	 * The main method of the Spring Boot application that runs the PharmacyManagementApplication class with the provided arguments.
	 * @param args The command line arguments to be passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PharmacyManagementApplication.class, args);
	}

}

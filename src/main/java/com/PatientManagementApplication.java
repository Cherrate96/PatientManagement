package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//main method
@SpringBootApplication
@ComponentScan(value= {"com","com.beans","com.controller","com.dao","com.exceptions","com.interfaces","com.services"})
@EnableTransactionManagement
@EntityScan(value= {"com.dao","com.beans","com.interfaces"})
@EnableJpaRepositories(basePackages = {"com.interfaces" })
public class PatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementApplication.class, args);
	}
}

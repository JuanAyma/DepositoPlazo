package com.bbva.contractmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // This annotation is used to register the microservice in the Eureka server
@SpringBootApplication
public class ContractMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractMicroserviceApplication.class, args);
	}

}

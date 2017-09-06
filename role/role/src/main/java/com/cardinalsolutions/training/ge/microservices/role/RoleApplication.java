package com.cardinalsolutions.training.ge.microservices.role;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.cardinalsolutions.training.ge.microservices.role.dao.IRoleRepo;
import com.cardinalsolutions.training.ge.microservices.role.domain.Role;


@EnableCircuitBreaker //enable the hystrix tolerance library
@EnableFeignClients //enables the feign clients to be active so it can talk to the actor and movie microservices
@EnableDiscoveryClient //enables ability to be found by the discovery client
@SpringBootApplication
public class RoleApplication {
	
	@Bean
	public CommandLineRunner demoData(IRoleRepo roleRepo){
		return (args) -> {
			roleRepo.save(new Role(1l, 1l, 1l, "Kamal", 1000.00));
			roleRepo.save(new Role(2l, 2l, 2l, "Megan", 1000.00));
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RoleApplication.class, args);
	}
}

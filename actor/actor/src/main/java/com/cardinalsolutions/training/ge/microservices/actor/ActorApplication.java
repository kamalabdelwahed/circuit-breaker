package com.cardinalsolutions.training.ge.microservices.actor;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.cardinalsolutions.training.ge.microservices.actor.dao.IActorRepo;
import com.cardinalsolutions.training.ge.microservices.actor.domain.Actor;

@EnableDiscoveryClient
@SpringBootApplication
public class ActorApplication {
	
	@SuppressWarnings("deprecation")
	@Bean
	public CommandLineRunner demoData(IActorRepo actorRepo){
		return (args) -> {
			actorRepo.save(new Actor(1l, "Kamal", "Abdelwahed", new Date()));
			actorRepo.save(new Actor(2l, "Megan", "Fox", new Date()));
			actorRepo.save(new Actor(3l, "Luke", "Skywalker", new Date()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ActorApplication.class, args);
	}
}

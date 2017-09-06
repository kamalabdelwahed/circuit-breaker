package com.cardinalsolutions.training.ge.microservices.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cardinalsolutions.training.ge.microservices.movie.dao.IMovieRepo;
import com.cardinalsolutions.training.ge.microservices.movie.domain.Movie;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieApplication {
	
	@Bean
	public CommandLineRunner demoData(IMovieRepo movieRepo){
		return (args) -> {
			movieRepo.save(new Movie(1l, "Office Space", 1997, "IT sucks", "http://google.com", 1l));
			movieRepo.save(new Movie(2l, "The Hangover", 2010, "Partay", "http://google.com", 2l));
			movieRepo.save(new Movie(3l, "2001", 2001, "A space adventure", "http://google.com", 2l));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}

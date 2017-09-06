package com.cardinalsolutions.training.ge.microservices.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cardinalsolutions.training.ge.microservices.genre.dao.IGenreRepo;
import com.cardinalsolutions.training.ge.microservices.genre.domain.Genre;

@EnableDiscoveryClient
@SpringBootApplication
public class GenreApplication {
	
	@Bean
	public CommandLineRunner demoData(IGenreRepo genreRepo){
		return (args) -> {
			genreRepo.save(new Genre(1l, "title 1", "description 1"));
			genreRepo.save(new Genre(2l, "title 2", "description 2"));
			genreRepo.save(new Genre(3l, "title 3", "description 3"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(GenreApplication.class, args);
	}
}

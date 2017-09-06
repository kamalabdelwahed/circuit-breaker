package com.cardinalsolutions.training.ge.microservices.role.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;

//tells the discovery microservice to look for the movie microservice
@FeignClient("movie")
public interface IMovieClient {
	
	//creating the link to the movie microservice
	@RequestMapping("/{movieId}")
	public Movie getMovieById(@PathVariable("movieId") Long movieId);

}

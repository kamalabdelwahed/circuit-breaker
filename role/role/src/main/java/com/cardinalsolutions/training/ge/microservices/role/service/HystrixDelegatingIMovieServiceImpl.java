package com.cardinalsolutions.training.ge.microservices.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service //tells spring that this is a bean it needs to manage
public class HystrixDelegatingIMovieServiceImpl implements IMovieService{
	
	@Autowired
	private IMovieClient movieClient;
	
	@HystrixCommand(fallbackMethod="fallback")
	@Override
	public Movie getMovieById(Long movieId) {
		return movieClient.getMovieById(movieId);
	}
	
	//this is the method that gets called if the above fails
	protected Movie fallback(Long movieId){
		//return a movie object with the id in the case of a failure
		Movie movie = new Movie();
		movie.setId(movieId);
		return movie;
	}

}

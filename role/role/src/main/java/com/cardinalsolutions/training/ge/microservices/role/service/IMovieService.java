package com.cardinalsolutions.training.ge.microservices.role.service;

import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;

public interface IMovieService {
	
	public Movie getMovieById(Long id);
	
}

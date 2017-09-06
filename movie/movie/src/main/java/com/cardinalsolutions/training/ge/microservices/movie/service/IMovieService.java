package com.cardinalsolutions.training.ge.microservices.movie.service;

import com.cardinalsolutions.training.ge.microservices.movie.domain.Movie;

public interface IMovieService {

	public Movie getMovieById(Long id);
}

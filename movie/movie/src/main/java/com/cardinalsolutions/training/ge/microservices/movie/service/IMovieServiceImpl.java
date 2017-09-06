package com.cardinalsolutions.training.ge.microservices.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinalsolutions.training.ge.microservices.movie.dao.IMovieRepo;
import com.cardinalsolutions.training.ge.microservices.movie.domain.Movie;
import com.cardinalsolutions.training.ge.microservices.movie.domain.MovieNotFoundException;

@Service
public class IMovieServiceImpl implements IMovieService{

	@Autowired
	private IMovieRepo movieRepo;
	
	@Override
	public Movie getMovieById(Long id) {
		Movie movie = movieRepo.findOne(id);
		
		if(movie == null){
			throw new MovieNotFoundException(id);
		}
		return movie;
	}

}

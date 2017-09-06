package com.cardinalsolutions.training.ge.microservices.movie.domain;

import java.util.List;

public class MovieListResponse {

	private List<Movie> movies;
	
	public MovieListResponse(){}
	
	public MovieListResponse(List<Movie> movies){
		this.movies=movies;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}

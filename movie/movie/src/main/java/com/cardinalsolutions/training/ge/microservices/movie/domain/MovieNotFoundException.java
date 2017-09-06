package com.cardinalsolutions.training.ge.microservices.movie.domain;

public class MovieNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2107449990041568067L;
	
	private Long movieId;
	
	public MovieNotFoundException(Long movieId){
		super("Movie " + movieId + " Not found");
		this.movieId = movieId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

}

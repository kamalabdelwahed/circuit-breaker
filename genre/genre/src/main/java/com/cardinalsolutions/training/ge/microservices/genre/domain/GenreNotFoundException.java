package com.cardinalsolutions.training.ge.microservices.genre.domain;

public class GenreNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3404973157371819536L;
	
	private Long genreId;
	
	public GenreNotFoundException(Long genreId){
		super("Genre " + genreId + " Not found");
		this.genreId = genreId;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

}

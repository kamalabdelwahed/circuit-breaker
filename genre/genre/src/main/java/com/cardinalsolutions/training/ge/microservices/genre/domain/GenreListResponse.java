package com.cardinalsolutions.training.ge.microservices.genre.domain;

import java.util.List;

public class GenreListResponse {

	private List<Genre> genre;
	
	public GenreListResponse(){}
	
	public GenreListResponse(List<Genre> genre){
		this.genre=genre;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

}

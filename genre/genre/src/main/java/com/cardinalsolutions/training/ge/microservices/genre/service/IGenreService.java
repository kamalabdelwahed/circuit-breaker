package com.cardinalsolutions.training.ge.microservices.genre.service;

import com.cardinalsolutions.training.ge.microservices.genre.domain.Genre;

public interface IGenreService {

	public Genre getGenreById(Long id);
}

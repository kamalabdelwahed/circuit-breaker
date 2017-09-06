package com.cardinalsolutions.training.ge.microservices.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinalsolutions.training.ge.microservices.movie.domain.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Long>{
	public List<Movie> findByGenreId(Long genreId);
}

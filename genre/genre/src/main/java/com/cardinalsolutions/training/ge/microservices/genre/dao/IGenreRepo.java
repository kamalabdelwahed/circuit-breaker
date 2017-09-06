package com.cardinalsolutions.training.ge.microservices.genre.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinalsolutions.training.ge.microservices.genre.domain.Genre;


public interface IGenreRepo extends JpaRepository<Genre, Long>{
//	public List<Genre> findByMovieId(Long movieId);

}

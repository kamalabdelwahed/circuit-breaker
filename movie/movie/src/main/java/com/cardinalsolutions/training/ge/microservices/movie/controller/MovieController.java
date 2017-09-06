package com.cardinalsolutions.training.ge.microservices.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cardinalsolutions.training.ge.microservices.movie.dao.IMovieRepo;
import com.cardinalsolutions.training.ge.microservices.movie.domain.Movie;
import com.cardinalsolutions.training.ge.microservices.movie.domain.MovieListResponse;
import com.cardinalsolutions.training.ge.microservices.movie.service.IMovieService;

@RestController
public class MovieController {

	@Autowired
	private IMovieRepo movieRepo;
	
	@Autowired
	private IMovieService movieService;
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting() {
		return "Yo yo";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable Long id){
		return movieService.getMovieById(id);
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public MovieListResponse getAllMovies() {
		return new MovieListResponse(movieRepo.findAll());
	}
	
	@RequestMapping(value="/genre/{genreId}", method=RequestMethod.GET)
	public MovieListResponse getMovieByGenreId(@PathVariable("genreId") Long genreId){
		return new MovieListResponse(movieRepo.findByGenreId(genreId));
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	public Movie createMovie(
			@RequestBody (required=true) Movie movie) {
		return movieRepo.save(movie);
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public void deleteMovie(@PathVariable("id") Long id){
		movieRepo.delete(id);
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public Movie updateMovieById(
			@PathVariable("id") Long id,
			@RequestBody (required=true) Movie movie) {
		
		movie.setId(id);
		return movieRepo.save(movie);
		
	}
}

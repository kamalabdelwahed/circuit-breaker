package com.cardinalsolutions.training.ge.microservices.genre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cardinalsolutions.training.ge.microservices.genre.dao.IGenreRepo;
import com.cardinalsolutions.training.ge.microservices.genre.domain.Genre;
import com.cardinalsolutions.training.ge.microservices.genre.domain.GenreListResponse;
import com.cardinalsolutions.training.ge.microservices.genre.service.IGenreService;

@RestController
public class GenreController {

	@Autowired
	private IGenreRepo genreRepo;
	
	@Autowired
	private IGenreService genreService;
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public GenreListResponse getAllGenres() {
		return new GenreListResponse(genreRepo.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Genre getGenre(@PathVariable("id") Long id){
		return genreService.getGenreById(id);
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	public Genre createGenre(
			@RequestBody (required=true) Genre genre) {
		return genreRepo.save(genre);
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public void deleteGenre(@PathVariable("id") Long id){
		genreRepo.delete(id);
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public Genre updateGenreById(
			@PathVariable("id") Long id,
			@RequestBody (required=true) Genre genre) {
		genre.setId(id);
		return genreRepo.save(genre);
	}
}

package com.cardinalsolutions.training.ge.microservices.genre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardinalsolutions.training.ge.microservices.genre.dao.IGenreRepo;
import com.cardinalsolutions.training.ge.microservices.genre.domain.Genre;
import com.cardinalsolutions.training.ge.microservices.genre.domain.GenreNotFoundException;

@Service
public class IGenreServiceImpl implements IGenreService{

	@Autowired 
	private IGenreRepo genreRepo;
	
	@Override
	public Genre getGenreById(Long id){
		Genre genre = genreRepo.findOne(id);
		
		if(genre == null){
			throw new GenreNotFoundException(id);
		}
		return genre;
	}	
}

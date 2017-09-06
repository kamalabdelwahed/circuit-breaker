package com.cardinalsolutions.training.ge.microservices.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinalsolutions.training.ge.microservices.role.dao.IRoleRepo;
import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;
import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;
import com.cardinalsolutions.training.ge.microservices.role.domain.Role;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleDetails;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleNotFoundException;

@Service
public class IRoleServiceImpl implements IRoleService{
	
	@Autowired 
	private IRoleRepo roleRepo;
	
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private IActorService actorService;
	
	@Override
	public RoleDetails getRoleById(Long id){
		
		Role role = roleRepo.findOne(id);
		
		if(role == null){
			throw new RoleNotFoundException(id);
		}
		RoleDetails roleDetails = new RoleDetails(role);
		Movie movie = movieService.getMovieById(role.getMovieId());
		roleDetails.setMovie(movie);
		Actor actor = actorService.getActorById(role.getActorId());
		roleDetails.setActor(actor);
		return roleDetails;
	}
}

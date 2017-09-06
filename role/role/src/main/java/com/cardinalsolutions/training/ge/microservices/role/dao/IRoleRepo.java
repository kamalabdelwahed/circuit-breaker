package com.cardinalsolutions.training.ge.microservices.role.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinalsolutions.training.ge.microservices.role.domain.Role;

public interface IRoleRepo extends JpaRepository<Role, Long>{

	public List<Role> findByMovieId (Long movieId);
	
	public List<Role> findByActorId (Long actorId);
	
}

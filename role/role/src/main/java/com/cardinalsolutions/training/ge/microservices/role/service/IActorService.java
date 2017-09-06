package com.cardinalsolutions.training.ge.microservices.role.service;

import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;

public interface IActorService {
	
	public Actor getActorById(Long actorId);

}

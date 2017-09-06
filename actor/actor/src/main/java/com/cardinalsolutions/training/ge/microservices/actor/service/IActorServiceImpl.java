package com.cardinalsolutions.training.ge.microservices.actor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinalsolutions.training.ge.microservices.actor.dao.IActorRepo;
import com.cardinalsolutions.training.ge.microservices.actor.domain.Actor;
import com.cardinalsolutions.training.ge.microservices.actor.domain.ActorNotFoundException;

@Service
public class IActorServiceImpl implements IActorService{
	
	@Autowired
	private IActorRepo actorRepo;

	@Override
	public Actor getActorById(Long id) {
		
		Actor actor = actorRepo.findOne(id);

		if(actor == null){
			throw new ActorNotFoundException(id);
		}
		return actor;
	}

}

package com.cardinalsolutions.training.ge.microservices.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service //tells spring that this is a bean it needs to manage
public class HystrixDelegationIActorServiceImpl implements IActorService{
	
	@Autowired
	private IActorClient actorClient;

	@Override
	@HystrixCommand(fallbackMethod="fallback")
	public Actor getActorById(Long actorId) {
		return actorClient.getActorById(actorId);
	}
	
	//this is the method that gets called if the above fails
	protected Actor fallback(Long actorId){
		//return a movie object with the id in the case of a failure
		Actor actor = new Actor();
		actor.setId(actorId);
		return actor;
		
	}

}

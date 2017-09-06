package com.cardinalsolutions.training.ge.microservices.actor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cardinalsolutions.training.ge.microservices.actor.dao.IActorRepo;
import com.cardinalsolutions.training.ge.microservices.actor.domain.Actor;
import com.cardinalsolutions.training.ge.microservices.actor.domain.ActorListResponse;
import com.cardinalsolutions.training.ge.microservices.actor.service.IActorService;

@RestController
public class ActorController {
	
	@Autowired
	private IActorRepo actorRepo;
	
	@Autowired
	private IActorService actorService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable Long id){
		return actorService.getActorById(id);
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public ActorListResponse getAllActors() {
		return new ActorListResponse(actorRepo.findAll());
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.POST)
	public Actor createActor(
			@RequestBody (required=true) Actor Actor) {
		return actorRepo.save(Actor);
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public void deleteActor(@PathVariable("id") Long id){
		actorRepo.delete(id);
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public Actor updateActorById(
			@PathVariable("id") Long id,
			@RequestBody (required=true) Actor Actor) {
		
		Actor.setId(id);
		return actorRepo.save(Actor);
		
	}
}

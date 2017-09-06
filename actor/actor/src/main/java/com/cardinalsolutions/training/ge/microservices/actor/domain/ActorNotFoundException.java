package com.cardinalsolutions.training.ge.microservices.actor.domain;

public class ActorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2129826176660382372L;
	
	private Long actorId;
	
	public ActorNotFoundException(Long actorId){
		super("Actor " + actorId + " Not found");
		this.actorId = actorId;
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	
	

}

package com.cardinalsolutions.training.ge.microservices.actor.service;

import com.cardinalsolutions.training.ge.microservices.actor.domain.Actor;

public interface IActorService {

	public Actor getActorById(Long id);
}

package com.cardinalsolutions.training.ge.microservices.actor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardinalsolutions.training.ge.microservices.actor.domain.Actor;

public interface IActorRepo  extends JpaRepository<Actor, Long>{

}

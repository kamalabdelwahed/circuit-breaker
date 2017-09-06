package com.cardinalsolutions.training.ge.microservices.role.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;

//tells the discovery microservice to look for the movie microservice
@FeignClient("actor")
public interface IActorClient {
	
	//creating the link to the movie microservice
	@RequestMapping("/{actorId}")
	public Actor getActorById(@PathVariable("actorId") Long actorId);


}

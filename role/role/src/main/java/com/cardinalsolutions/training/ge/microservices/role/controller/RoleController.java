package com.cardinalsolutions.training.ge.microservices.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardinalsolutions.training.ge.microservices.role.dao.IRoleRepo;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleDetails;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleListResponse;
import com.cardinalsolutions.training.ge.microservices.role.service.IRoleService;

@RestController
public class RoleController {
	
	@Autowired
	private IRoleRepo roleRepo;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public RoleListResponse getAllRoles(){
		return new RoleListResponse(roleRepo.findAll());
	}
	
	@RequestMapping(value="/{roleId}", method=RequestMethod.GET)
	public RoleDetails getRoleById(@PathVariable("roleId") Long roleId){
		return roleService.getRoleById(roleId);
	}

	@RequestMapping(value="/movie/{movieId}", method=RequestMethod.GET)
	public RoleListResponse getRoleByMovieId(@PathVariable("movieId") Long movieId){
		return new RoleListResponse(roleRepo.findByMovieId(movieId));
	}
	
	@RequestMapping(value="/actor/{actorId}", method=RequestMethod.GET)
	public RoleListResponse getRoleByActorId(@PathVariable("actorId") Long actorId){
		return new RoleListResponse(roleRepo.findByActorId(actorId));
	}
}

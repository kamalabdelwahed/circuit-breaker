package com.cardinalsolutions.training.ge.microservices.role.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cardinalsolutions.training.ge.microservices.role.domain.RoleNotFoundException;

//used to handle exceptions
@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.NOT_FOUND) //allows the controller to return a 404
	@ExceptionHandler(RoleNotFoundException.class) //indicates which exception the controller should return
	public Map<String, String> handleNoRole(RoleNotFoundException e){
		return Collections.singletonMap("error",
				"Role id (" + e.getRoleId() +") not found");
	}
}

package com.cardinalsolutions.training.ge.microservices.role.domain;

import java.util.List;

public class RoleListResponse {
	
	private List<Role> role;
	
	public RoleListResponse(){}
	
	public RoleListResponse(List<Role> role){
		this.role = role;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
	

}

package com.cardinalsolutions.training.ge.microservices.role.domain;

public class RoleNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6435569637276203631L;
	
	private Long roleId;
	
	public RoleNotFoundException(Long roleId){
		super("Role " + roleId + " not found");
		this.roleId = roleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}

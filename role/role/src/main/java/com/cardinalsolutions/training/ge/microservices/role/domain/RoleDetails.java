package com.cardinalsolutions.training.ge.microservices.role.domain;

public class RoleDetails {

	private Long id;
	
	private Actor actor;
	
	private Movie movie;
	
	private String charName;
	
	private Double salary;
	
	public RoleDetails(){}
	
	public RoleDetails(Role role){
		this.id = role.getId();
		this.charName = role.getCharName();
		this.salary = role.getSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	
}

package com.cardinalsolutions.training.ge.microservices.role.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Role {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private Long actorId;
	
	@Column
	private Long movieId;
	
	@Column
	private String charName;
	
	@Column
	private Double  salary;
	
	public Role (){}
	
	public Role(Long id, Long actorId, Long movieId, String charName, Double  salary){
		this.id = id;
		this.actorId = actorId;
		this.movieId = movieId;
		this.charName = charName;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
}

package com.cardinalsolutions.training.ge.microservices.movie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String synopsis;
	
	@Column
	private int year;
	
	@Column
	private String imageUrl;
	
	@Column
	private Long genreId;
	
	public Movie() {}
	
	public Movie(Long id, String title, int year, String synopsis, String imageUrl, long genreId){
		this.id=id;
		this.title=title;
		this.year=year;
		this.imageUrl=imageUrl;
		this.synopsis=synopsis;
		this.genreId=genreId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	
	
}

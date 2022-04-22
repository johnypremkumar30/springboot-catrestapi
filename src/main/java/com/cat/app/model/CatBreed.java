package com.cat.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catbreed")
public class CatBreed {

	@Id
	private Long id;
	private String name;
	private String height;
	private String weight;
	private String lifeSpan;
	private String breedFor;
	private String breedGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getBreedFor() {
		return breedFor;
	}

	public void setBreedFor(String breedFor) {
		this.breedFor = breedFor;
	}

	public String getBreedGroup() {
		return breedGroup;
	}

	public void setBreedGroup(String breedGroup) {
		this.breedGroup = breedGroup;
	}

	public CatBreed(Long id, String name, String height, String weight, String lifeSpan, String breedFor,
			String breedGroup) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.lifeSpan = lifeSpan;
		this.breedFor = breedFor;
		this.breedGroup = breedGroup;
	}

	public CatBreed() {
		super();
	}

}

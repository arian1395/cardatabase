package com.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator = "Owner_SEQ")
	private long id;
	private String firstname, lastname;
	
	public Owner() {}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@OneToMany(cascade= CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

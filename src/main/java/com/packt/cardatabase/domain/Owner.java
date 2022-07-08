package com.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="car_owner",
			joinColumns = { @JoinColumn(name="owner_id") },
			inverseJoinColumns = { @JoinColumn(name="car_id") })
	private Set<Car> cars = new HashSet<>();
	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
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

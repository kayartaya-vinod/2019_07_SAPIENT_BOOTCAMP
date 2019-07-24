package com.publicissapient.training.entity;

public class Customer {

	// fields
	private int id;
	private String name;
	private String city;
	private String phone;
	private String email;

	// constructor
	// best practice to add a no-arg constructor
	public Customer() {
	}

	// getter / accessor / readable property for 'id' field
	public int getId() {
		return this.id;
	}

	// setter / mutator / writable property for 'id' field
	public void setId(int id) {
		if (id <= 0) {
			throw new RuntimeException("Value for id is invalid: " + id);
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3 || name.length() > 20) {
			throw new RuntimeException("Invalid length for name!");
		}
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

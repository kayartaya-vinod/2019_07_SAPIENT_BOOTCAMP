package com.publicissapient.training.entity;

public class Customer {
	
	int id;
	String name;
	String city;
	String phone;
	String email;

	public void print() {
		System.out.println("id = " + id);
		System.out.println("name = " + name);
		System.out.println("city = " + city);
		System.out.println("phone = " + phone);
		System.out.println("email = " + email);
		System.out.println();
	}
	
}

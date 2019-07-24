package com.publicissapient.training.entity;

public class Employee {

	private static int idCounter;

	private final int id;
	private String name;
	private double salary;
	private Gender gender;

	public Employee() {
		id = ++idCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {
		if(name==null || name.length()<3 || name.length()>25) {
			throw new InvalidNameException("Invalid name. Must have 3 to 25 letters.");
		}
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws InvalidSalaryException {
		if(salary<15000.0) {
			throw new InvalidSalaryException("Invalid salary. Must be >= Rs.15000.0");
		}
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + "]";
	}

}

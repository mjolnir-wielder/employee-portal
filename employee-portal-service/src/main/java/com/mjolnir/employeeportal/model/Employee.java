package com.mjolnir.employeeportal.model;

import java.util.UUID;

public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String dob;
	private Gender gender;
	private Department department;

	public Employee(String firstName, String lastName, String dob, Gender gender, Department department) {
		super();
		this.id = this.generateUuid();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.department = department;
	}
	
	private String generateUuid() {
		return UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", dob=").append(dob).append(", gender=").append(gender)
				.append(", department=").append(department).append("]");
		return builder.toString();
	}
}

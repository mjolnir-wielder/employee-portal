package com.mjolnir.employeeportal.model;

public class Employee implements Comparable<Employee> {

	private String id;
	private String name;
	private int age;
	private String contactNumber;
	private Designation designation;
	private Department department;

	public Employee(String id, String name, int age, String contactNumber, Designation title, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contactNumber = contactNumber;
		this.designation = title;
		this.department = department;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int compareTo(Employee emp) {
		return this.age - emp.age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", name=").append(name).append(", age=").append(age)
				.append(", contactNumber=").append(contactNumber).append(", title=").append(designation)
				.append(", department=").append(department).append("]");
		return builder.toString();
	}

}

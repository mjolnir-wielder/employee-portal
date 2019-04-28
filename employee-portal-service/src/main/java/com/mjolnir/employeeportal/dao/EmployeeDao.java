package com.mjolnir.employeeportal.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mjolnir.employeeportal.model.Department;
import com.mjolnir.employeeportal.model.Employee;
import com.mjolnir.employeeportal.model.Gender;

@Repository
public class EmployeeDao {
	
	private static List<Employee> employees;
	
	static {
		EmployeeDao.employees = new ArrayList<>();
		Employee employee1 = new Employee("Ankit", "Agarwal", "02-10-1992", Gender.Male, Department.Prime_Brokerage);
		Employee employee2 = new Employee("Animesh", "Chaturvedi", "15-09-1994", Gender.Male, Department.Prime_Brokerage);
		Employee employee3 = new Employee("Surbhi", "Jain", "27-02-1990", Gender.Female, Department.Prime_Brokerage);
		Employee employee4 = new Employee("Rahul", "Mishra", "11-10-1993", Gender.Male, Department.Prime_Brokerage);
		Employee employee5 = new Employee("Varun", "Kumar", "30-11-1991", Gender.Male, Department.Fund_Services);
		Employee employee6 = new Employee("Sakshi", "Agarwal", "03-12-1994", Gender.Female, Department.Fund_Services);
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
	}
	
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	public Employee addEmployee(Employee employee) {
		employees.add(employee);
		return employee;
	}
}

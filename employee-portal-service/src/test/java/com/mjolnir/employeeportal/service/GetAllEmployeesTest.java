package com.mjolnir.employeeportal.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mjolnir.employeeportal.dao.EmployeeDao;
import com.mjolnir.employeeportal.model.Department;
import com.mjolnir.employeeportal.model.Employee;
import com.mjolnir.employeeportal.model.Gender;

@RunWith(MockitoJUnitRunner.class)
public class GetAllEmployeesTest {
	
	@Mock
	private EmployeeDao employeeDaoMock;
	
	@InjectMocks
	private GetAllEmployees getAllEmployees;
	
	@Test
	public void test_getting_all_employees() {
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = new Employee("Ankit", "Agarwal", "02-10-1992", Gender.Male, Department.Prime_Brokerage);
		Employee employee2 = new Employee("Animesh", "Chaturvedi", "15-09-1994", Gender.Male, Department.Prime_Brokerage);
		employees.add(employee1);
		employees.add(employee2);
		when(employeeDaoMock.getAllEmployees()).thenReturn(employees);
		assertEquals(employees, getAllEmployees.execute());
	}

}

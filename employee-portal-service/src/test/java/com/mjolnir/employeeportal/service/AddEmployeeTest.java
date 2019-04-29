package com.mjolnir.employeeportal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.mjolnir.employeeportal.dao.EmployeeDao;
import com.mjolnir.employeeportal.model.Department;
import com.mjolnir.employeeportal.model.Employee;
import com.mjolnir.employeeportal.model.Gender;

@RunWith(MockitoJUnitRunner.class)
public class AddEmployeeTest {
	
	@Mock
	private EmployeeDao employeeDaoMock;
	
	@InjectMocks
	private AddEmployee addEmployee;
	
	@Test
	public void test_adding_employee() {
		Employee employeeMock = new Employee("Animesh", "Chaturvedi", "15-09-1994", Gender.Male, Department.Prime_Brokerage);
		when(employeeDaoMock.addEmployee(employeeMock)).thenReturn(employeeMock);
		assertEquals(employeeMock, addEmployee.execute(employeeMock));
	}

}

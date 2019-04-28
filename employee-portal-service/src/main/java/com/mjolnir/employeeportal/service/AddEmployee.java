package com.mjolnir.employeeportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjolnir.employeeportal.dao.EmployeeDao;
import com.mjolnir.employeeportal.model.Employee;

@Service
public class AddEmployee {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee execute(Employee employee) {
		return this.employeeDao.addEmployee(employee);
	}
}

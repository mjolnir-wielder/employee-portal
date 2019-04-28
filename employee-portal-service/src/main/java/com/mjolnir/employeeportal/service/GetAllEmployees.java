package com.mjolnir.employeeportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjolnir.employeeportal.dao.EmployeeDao;
import com.mjolnir.employeeportal.model.Employee;

@Service
public class GetAllEmployees {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> execute() {
		return employeeDao.getAllEmployees();
	}
}

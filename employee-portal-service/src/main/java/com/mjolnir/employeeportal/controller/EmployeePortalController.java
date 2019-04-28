package com.mjolnir.employeeportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjolnir.employeeportal.model.Employee;
import com.mjolnir.employeeportal.service.AddEmployee;
import com.mjolnir.employeeportal.service.GetAllEmployees;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/employeeportal")
@Api(value="employeeportal")
public class EmployeePortalController {
	
	@Autowired
	private GetAllEmployees getAllEmployees;
	
	@Autowired
	private AddEmployee addEmployee;
	
    @GetMapping("/employees")
    @ApiOperation(value = "produces a list of all employees", response = String.class)
    public List<Employee> getAllEmployees() {
    	return this.getAllEmployees.execute();
    }
    
    @PostMapping("/employee")
    @ApiOperation(value = "Adds an employee to the existing collection", response = String.class)
    public Employee AddEmployee(@RequestBody Employee employee) {
        return this.addEmployee.execute(employee);
    }

}

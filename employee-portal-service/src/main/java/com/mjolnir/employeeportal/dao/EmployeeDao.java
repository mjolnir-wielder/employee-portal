package com.mjolnir.employeeportal.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mjolnir.employeeportal.model.Department;
import com.mjolnir.employeeportal.model.Designation;
import com.mjolnir.employeeportal.model.Employee;

@Repository
public class EmployeeDao {
	
	private static Map<String, Employee> employeeStore;
	
	static {
		employeeStore = new HashMap<>();
		employeeStore.put("pb_mngr_1", new Employee("pbe_mngr_1", "Ankit Agarwal", 26, "+911122334455", Designation.Manager, Department.Prime_Brokerage));
		employeeStore.put("pb_assoc_2", new Employee("pbe_assoc_2", "Animesh Chaturvedi", 24, "+911127894561", Designation.Associate, Department.Prime_Brokerage));
		employeeStore.put("pb_vp_3", new Employee("pbe_vp_3", "Surbhi Jain", 29, "+911122396385", Designation.Vice_President, Department.Prime_Brokerage));
		employeeStore.put("pb_assoc_4", new Employee("pbe_assoc_4", "Rahul Mishra", 25, "+914567834455", Designation.Associate, Department.Prime_Brokerage));
		employeeStore.put("fndsvc_mngr_5", new Employee("fndsvc_mngr_5", "Varun Kumar", 27, "+911238527855", Designation.Manager, Department.Fund_Services));
		employeeStore.put("fndsvc_assoc_6", new Employee("fndsvc_assoc_6", "Sakshi Agarwal", 23, "+911191735455", Designation.Associate, Department.Fund_Services));
	}
	
	public List<Employee> getAllEmployees() {
		return new ArrayList<>(employeeStore.values());
	}
	
	public Employee addEmployee(Employee employee) {
		String id = this.generateUuid();
		String employeeId = this.getEmployeeId(employee, id);
		employee.setId(employeeId);
		employeeStore.put(id, employee);
		return employee;
	}
	
	private String generateUuid() {
		return UUID.randomUUID().toString();
	}
	
	private String getEmployeeId(Employee employee, String uuid) {
		return employee.getDepartment().getValue() + "_" + employee.getDesignation().getValue() + "_" + uuid;
	}

}

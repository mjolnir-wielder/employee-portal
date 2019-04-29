package com.mjolnir.employeeportal.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjolnir.employeeportal.model.Department;
import com.mjolnir.employeeportal.model.Employee;
import com.mjolnir.employeeportal.model.Gender;
import com.mjolnir.employeeportal.service.AddEmployee;
import com.mjolnir.employeeportal.service.GetAllEmployees;

public class EmployeePortalControllerTest {

	private MockMvc mockMvc;

	@Mock
	private AddEmployee addEmployeeMock;

	@Mock
	private GetAllEmployees getAllEmployeesMock;

	@InjectMocks
	private EmployeePortalController employeePortalController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeePortalController).build();
	}

	// =========================================== Get All Employees ==========================================

	@Test
	public void test_get_all_success() throws Exception {
		List<Employee> employees = Arrays.asList(
				new Employee("Ankit", "Agarwal", "02-10-1992", Gender.Male, Department.Prime_Brokerage),
				new Employee("Animesh", "Chaturvedi", "15-09-1994", Gender.Male, Department.Prime_Brokerage));

		when(getAllEmployeesMock.execute()).thenReturn(employees);

		mockMvc.perform(get("/employee-portal/employees")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].firstName", is("Ankit")))
				.andExpect(jsonPath("$[0].lastName", is("Agarwal")))
				.andExpect(jsonPath("$[1].firstName", is("Animesh")))
				.andExpect(jsonPath("$[1].lastName", is("Chaturvedi")));
	}

	// =========================================== Add an employee ==========================================

	@Test
	public void test_add_employee_success() throws Exception {
		Employee employeeMock = new Employee("Ankit", "Agarwal", "02-10-1992", Gender.Male, Department.Prime_Brokerage);

		when(addEmployeeMock.execute(employeeMock)).thenReturn(employeeMock);

		mockMvc.perform(post("/employee-portal/employee").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(employeeMock))).andExpect(status().isOk());
	}

	/*
	 * converts a Java object into JSON representation
	 */
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

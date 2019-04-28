package com.mjolnir.employeeportal.model;

public enum Department {

	Fund_Services("fndsvc"), Prime_Brokerage("pb");

	private String value;

	Department(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}

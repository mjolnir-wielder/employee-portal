package com.mjolnir.employeeportal.model;

public enum Designation {

	Vice_President("vp"), Associate("assoc"), Manager("mngr");

	private String value;

	Designation(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}

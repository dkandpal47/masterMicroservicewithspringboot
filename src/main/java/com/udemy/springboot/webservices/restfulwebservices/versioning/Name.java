package com.udemy.springboot.webservices.restfulwebservices.versioning;

public class Name {
	
	String firstName;
	String lastName;
	
	
	public Name() {
		super();
	}

	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

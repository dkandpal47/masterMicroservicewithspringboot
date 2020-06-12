package com.udemy.springboot.webservices.restfulwebservices.versioning;

import com.udemy.springboot.webservices.restfulwebservices.versioning.Name;

public class PersonV2 {
	
	public PersonV2() {
		super();
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	private Name name;

	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}

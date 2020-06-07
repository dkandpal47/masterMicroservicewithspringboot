package com.udemy.springboot.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {
		
	private String message;

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	//Without getter won't work , end point will throw exception
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}

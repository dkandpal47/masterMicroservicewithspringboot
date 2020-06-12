package com.udemy.springboot.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Basic way of versioning says map version with 2 different URI 
 * v1/person  and v2/person
 * 
 * way 2 (parameter versioning): use parameter in the request header such as 
 * endpoint/version=1?name=user
 * endpoint/version=2?name=user
 * 
 * way 3 (Custom Header Versioning)  using header information 
 * set parameter in header of request
 * 
 * Way 4 (Media Type Versioning) : as similar as 3rd one but rather setting direct attribute in header
 * let say we define what it accepts , for that we can use produces attribute 
 */
@RestController
public class VersioningController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob kumar kushwaha");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob kumar", "kushwaha"));
	}
	
	@GetMapping(value ="/person", params = "version=1")
	public PersonV1 personUsingParamV1() {
		return new PersonV1("Bob kumar kushwaha");
	}
	
	@GetMapping(value ="/person", params = "version=2")
	public PersonV2 personUsingParamV2() {
		return new PersonV2(new Name("Bob kumar", "kushwaha"));
	}
	
	// Way 3
	@GetMapping(value ="/person", headers  = "X-API-VERSION=1")
	public PersonV1 personUsingheaderV1() {
		return new PersonV1("Bob kumar kushwaha HEADER");
	}
	
	@GetMapping(value ="/person", headers  = "X-API-VERSION=2")
	public PersonV2 personUsingheaderV2() {
		return new PersonV2(new Name("Bob kumar", "kushwaha"));
	}
	
	//way 4
	@GetMapping(value ="/person", produces  = "application/person-v1+json")
	public PersonV1 personUsingproducesV1() {
		return new PersonV1("Bob kumar kushwaha Produces");
	}
	
	@GetMapping(value ="/person", produces  = "application/person-v2+json")
	public PersonV2 personUsingproducesV2() {
		return new PersonV2(new Name("Bob kumar", "kushwaha"));
	}
}

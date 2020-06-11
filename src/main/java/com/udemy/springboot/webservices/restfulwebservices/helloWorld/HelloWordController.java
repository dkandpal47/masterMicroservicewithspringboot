package com.udemy.springboot.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	//Define GET 
	//Define Method 
	//Map URI with method
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-word")
	public String helloWord() {
		return "=======> Hello World Dinesh Kandpal \n without bean <======";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-word-bean")
	public HelloWorldBean helloWordBean() {
		return new HelloWorldBean("Hello World (Bean)");
	}
	
	//with pth varible /hello-word/path-variable/dinesh
	//Without using @PathVariable annotion with bean it will pass null
	@GetMapping(path="/hello-word/{name}")
	public HelloWorldBean helloWordBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s in the World",name));
	}
	
	//Concept of internationalization
	@GetMapping(path="/hello-word-international")
	public String helloWordInternational(@RequestHeader(name = "lang",required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}

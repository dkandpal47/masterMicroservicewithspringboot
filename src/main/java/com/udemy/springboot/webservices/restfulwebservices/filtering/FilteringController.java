package com.udemy.springboot.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retriveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	/*Just want to send field 1 and field 2 
	 * Dynamic filtering doesn't works at the level of bean class
	 */
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retriveDynamicSomeBean() {
		SomeBean sBean =  new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sBean);
		
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
		
	}
}
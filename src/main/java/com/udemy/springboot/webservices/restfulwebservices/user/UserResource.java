package com.udemy.springboot.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@SuppressWarnings("deprecation")
@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	//fetch all users
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return userDaoService.findAll();
	}
	
	//fetch specific user
	@GetMapping("/users/{userId}")
	public EntityModel<User> retriveUser(@PathVariable int userId)
	{
		User user = userDaoService.findUser(userId);
		
		if(user == null)
		{
			throw new UserNotFoundException("USer Not Found for ID : "+userId);
		}
		
		EntityModel<User> userModel = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
									.linkTo(ControllerLinkBuilder.methodOn(this.getClass())
									.retriveAllUsers());
		userModel.add(linkTo.withRel("all-users"));
		return userModel;
	}
	
	//create new user by post request use @RequestBody annotation
	//Input : user Object without id (id will declare from the backend)
	//output : Status : Created (apart from 200, ok), user uri
	//@valid to bind that request neeed to pass through validation.
	@PostMapping("/users")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody User user)
	{
		User savUser = userDaoService.save(user);
		
		URI endPoint = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savUser.getId())
		.toUri();
		
		return ResponseEntity.created(endPoint).build();
	}
	
	@DeleteMapping("/users/delete/{userId}")
	public void deleteUserById(@PathVariable  int userId)
	{
		User user = userDaoService.deleteUserById(userId);
		
		if(user == null)
		{
			throw new UserNotFoundException("Unable to delete. \n No User Found with Id :"+userId);
		}
		
	}
}

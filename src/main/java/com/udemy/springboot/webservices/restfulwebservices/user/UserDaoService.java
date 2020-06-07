package com.udemy.springboot.webservices.restfulwebservices.user;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users  = new ArrayList<>();
	
	private static int userCount = 4;
	
	static {
		users.add(new User(1,"Ram",new Date()));
		users.add(new User(2,"shyam",new Date()));
		users.add(new User(3,"abhishek",new Date()));
		users.add(new User(4,"justin",new Date()));
	}
	
	
	//method to fetch all users
	public List<User> findAll()
	{
		return users;
	}
	
	//Method to fetch specifiv user based on ID
	public User findUser(int id)
	{
		for(User u : users)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}
	
	//Method to save the user to the list
	public User save(User user)
	{
		if(user.getId() == null)
		{
			user.setId(++userCount);
		}
			
		users.add(user);
		return user;
			
	}

	//Method to delete the user from the Repository
		public User deleteUserById(int userId)
		{
			//Using iterator as we have to delete and iterate same time
			Iterator<User> uIterator =  users.iterator();
 			
			while(uIterator.hasNext())
			{
				User user = uIterator.next();
				if(user.getId() == userId)
				{
					uIterator.remove();
					return user;
				}
			}
			return null;				
		}
}

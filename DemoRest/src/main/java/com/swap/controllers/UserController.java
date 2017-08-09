package com.swap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.swap.model.User;
import com.swap.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class UserController {

	@Autowired
	private UserService userService;	
	
		//Add a user
		@RequestMapping(value="/addUser", method=RequestMethod.POST,headers="Accept=application/json")
		public void addUser(@RequestBody User user)
		{
			boolean flag=userService.saveUser(user);
			if(flag)	
			System.out.println("User Successfully Inserted");
			else
				System.out.println("Error in Inseerting user in database");
		}
		
		//Validate User
		@RequestMapping(value="/validateUser/{email}/{password}",method=RequestMethod.GET,headers="Accept=application/json")
		public boolean validateUser(@PathVariable("email") String email,@PathVariable("password") String password){
			
			boolean flag=userService.validateUser(email, password);
			if(flag){
			System.out.println("User Validated Successfully and is present");return true;}
			else{
				System.out.println("User Not present in database");return false;}
		}
		
}

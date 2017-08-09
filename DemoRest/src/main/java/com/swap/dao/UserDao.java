package com.swap.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.swap.model.User;;

@ComponentScan("com.swap")
@Repository
public interface UserDao {

	boolean saveUser(User user);
	
	boolean validateUser(String email,String password);
	
}

package com.swap.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.swap.dao.UserDao;
import com.swap.model.User;

@Transactional
@Repository(value="UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	public boolean saveUser(User user) {
		return	userDao.saveUser(user);
		
	}

	public boolean validateUser(String email, String password) {
		
		return userDao.validateUser(email, password);
	}

}

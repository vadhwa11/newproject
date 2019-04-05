package com.icg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icg.dao.UserDao;
import com.icg.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User validateUser(User user) {
		
		return userDao.validateUser(user);
	}
}

package com.aya.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aya.spring.web.daos.User;
import com.aya.spring.web.daos.UsersDao;

@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	
	@Autowired
	public void setOffersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	
	public void create(User user) {
		usersDao.create(user);
	}



	public boolean exists(String username) {
		usersDao.exists(username);
		return false;
	}


	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}


	public void update(User user) {
		// TODO Auto-generated method stub
		usersDao.update(user);
	}
}

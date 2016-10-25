package com.instantshare.services.impl;

import java.sql.SQLException;

import com.instantshare.dao.UserDao;
import com.instantshare.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public boolean isValidUser(String username, String password){
		// TODO Auto-generated method stub
		try {
			return userDao.dbValidateUser(username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

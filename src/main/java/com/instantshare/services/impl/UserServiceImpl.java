package com.instantshare.services.impl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.instantshare.dao.UserDao;
import com.instantshare.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
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

	public boolean register(Map<String, Object> userInfo) {
		try {
			return userDao.dbRegisterUser(userInfo);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

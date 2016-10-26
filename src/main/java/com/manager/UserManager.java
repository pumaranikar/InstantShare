package com.manager;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.instantshare.services.UserService;

public class UserManager {
	
	@Autowired
	private UserService userService;
	
	public boolean validateUserIdentity(String username, String password) throws SQLException {
		
		return userService.isValidUser(username, password);
	}

	public boolean registerUser(Map<String, Object> userInfo) throws SQLException {
		
		return userService.register(userInfo);
	}
}

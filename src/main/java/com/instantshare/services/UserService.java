package com.instantshare.services;

import java.util.Map;

public interface UserService {

	public boolean isValidUser(String username, String password);
	public boolean register(Map<String, Object> userInfo);
}

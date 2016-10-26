package com.instantshare.dao;

import java.sql.SQLException;
import java.util.Map;

public interface UserDao {
	
		public boolean dbValidateUser(String username, String password) throws SQLException;
		public boolean dbRegisterUser(Map<String, Object> userInfo) throws SQLException;
}

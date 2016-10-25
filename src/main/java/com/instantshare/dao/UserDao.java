package com.instantshare.dao;

import java.sql.SQLException;

public interface UserDao {
	
		public boolean dbValidateUser(String username, String password) throws SQLException;
}

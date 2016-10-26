package com.instantshare.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.instantshare.dao.UserDao;

public class UserDaoImpl implements UserDao {

	public boolean dbValidateUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		 String query;
		    boolean login = false;

		    try {
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        Connection con = DriverManager.getConnection("connectionString", "dbUsername", "dbPassword");
		        Statement stmt = (Statement) con.createStatement();
		        query = "SELECT username, password FROM user WHERE username='" + username + "' AND password='" + password + "';";
		        System.out.println("username"+username+"pwd"+password);
		        stmt.executeQuery(query);
		        ResultSet rs = stmt.getResultSet();
		        login = rs.first(); //rs.first();
		        con.close();
		    } catch (InstantiationException e) {
		        e.printStackTrace();
		    } catch (IllegalAccessException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return login;
		
		
	}

	public boolean dbRegisterUser(Map<String, Object> userInfo) throws SQLException {
		// TODO Auto-generated method stub
		
		 String query;
		    try {
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        Connection con = DriverManager.getConnection("connectionString", "dbUsername", "dbPassword");
		        Statement stmt = (Statement) con.createStatement();
		        query = "INSERT into user (name, username, password, email) values ('"+userInfo.get("name")+"','"+userInfo.get("username")+"','"+userInfo.get("password")+"','"+userInfo.get("email")+"')";
		        stmt.executeUpdate(query);
		        System.out.println("User Inserted successfully");
		        con.close();
		    } catch (InstantiationException e) {
		        e.printStackTrace();
		    } catch (IllegalAccessException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
		
		return false;
	}

}

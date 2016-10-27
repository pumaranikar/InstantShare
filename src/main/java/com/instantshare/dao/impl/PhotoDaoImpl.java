package com.instantshare.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.instantshare.dao.PhotoDao;
import com.model.PhotoDetails;

public class PhotoDaoImpl implements PhotoDao{

	@Override
	public boolean insertPhotoDetails(PhotoDetails photo_details) {
		// TODO Auto-generated method stub
		

		 String query;
		    try {
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        Connection con = DriverManager.getConnection("connectionString", "dbUsername", "dbPassword");
		        Statement stmt = (Statement) con.createStatement();
		        query = "INSERT into picture (pic_meta, pic_owner, pic_timestamp) values ('"+photo_details.getPhotoName()+"','"+photo_details.getPhotoOwner()+"','"+photo_details.getDate()+"')";
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

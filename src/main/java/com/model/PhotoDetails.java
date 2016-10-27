package com.model;

import java.util.Date;

public class PhotoDetails {

	String PhotoOwner;
	String PhotoName;
	Date date;
	
	public String getPhotoOwner() {
		return PhotoOwner;
	}
	public void setPhotoOwner(String photoOwner) {
		PhotoOwner = photoOwner;
	}
	public String getPhotoName() {
		return PhotoName;
	}
	public void setPhotoName(String photoName) {
		PhotoName = photoName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

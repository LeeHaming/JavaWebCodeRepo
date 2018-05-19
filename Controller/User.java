package com.WeChat.leeham;

public class User {
	private String userNumber;
	private String userName;
	private String teacherName;
	private int checkIn;
	private String address;
	
	public void setUserNumber(String userNumber){
		this.userNumber=userNumber;
	}
	public String getUserNumber(){
		return userNumber;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	
	public void setTeacherName(String teacherName){
		this.teacherName=teacherName;
	}
	public String getTeacherName(){
		return teacherName;
	}
	
	
	public void setCheckIn(int checkIn){
		this.checkIn=checkIn;
	}
	public int getCheckIn(){
		return checkIn;
	}
	
	public void setUserAddress(String address){
		this.address=address;
	}
	public String getUserAddress(){
		return address;
	}
}

package com.wyt.travelShare.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{

	private Integer userId;
	private String userName;
	private String password;
	private String phoneNum;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 包含全部参数的构造方法
	 * @param userId
	 * @param userName
	 * @param password
	 * @param phoneNum
	 */
	public User(Integer userId, String userName, String password, String phoneNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNum = phoneNum;
	}
	
	/*
	 * 空参构造
	 */
	public User() {
		
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNum=" + phoneNum
				+ "]";
	}
	
	
}

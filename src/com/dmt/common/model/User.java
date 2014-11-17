package com.dmt.common.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User
{
	Logger logger = LoggerFactory.getLogger(com.dmt.common.model.User.class);
	private int no = 0;
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String userName = "";
	private String password = "";
	private String email = "";
	private String role = "";
	
	
	//getters and setters
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		logger.debug("setting no = {}", this.no);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		logger.debug("setting firstName = {}", this.firstName);
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
		logger.debug("setting middleName = {}", this.middleName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		logger.debug("setting lastName = {}", this.lastName);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		logger.debug("setting userName = {}", this.userName);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		logger.debug("setting password = {}", this.password);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
		logger.debug("setting role = {}", this.role);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		logger.debug("setting email = {}", this.email);
	}
}


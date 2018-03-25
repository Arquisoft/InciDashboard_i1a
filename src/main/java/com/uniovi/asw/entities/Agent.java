package com.uniovi.asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agent {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	private String password;
	private String location;
	
	public Agent() {
		
	}
	
	public Agent(String userName, String password, String location) {
		this.userName = userName;
		this.password = password;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

package com.uniovi.asw.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OPERATORS")
public class Operator {
	
	@Id
	private String id;
	private String username;
	private String password;
	
	public Operator(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Operator() {
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

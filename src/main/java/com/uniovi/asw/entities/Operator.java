package com.uniovi.asw.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Operator {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "operator", cascade = CascadeType.ALL)
	@ElementCollection(targetClass=Incident.class)
	private List<Incident> incidents = new ArrayList<Incident>();
	
	public Operator(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Operator() {
	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
}

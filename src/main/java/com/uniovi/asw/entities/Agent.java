package com.uniovi.asw.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "loader_i1a_collection") // Esta coleccion se usa para la bd remota
public class Agent {

	@Id
	private String idautogenerado;

	private String name;
	private String email;
	private String password;
	private String location;
	private String id;
	private int kind;

	public Agent() {
	}

	public Agent(String name, String email, String password, String id, int kind) {
		this.name = name;
		this.email = email;
		this.kind = kind;
		this.id = id;
		this.password = password;
		this.location = "";
		this.kind = kind;
	}

	public Agent(String name, String email, String password, String location, String id, int kind) {
		this(name, email, password, id, kind);
		this.location = location;
	}

	public Agent(String[] data) {
		this(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]));
	}

	public String getIdautogenerado() {
		return idautogenerado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getLocation() {
		return location;
	}

	public String getId() {
		return id;
	}

	public int getKind() {
		return this.kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	
	@Override
	public String toString() {
		return "Agent [idautogenerado='" + idautogenerado + "', name='" + name + "', email='"
				+ email + "', password='" + password + "', location='" + location + "', id='" + id
				+ "', kind=" + kind + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Agent agentInfo = (Agent) o;
		return kind == agentInfo.kind && Objects.equals(idautogenerado, agentInfo.idautogenerado)
				&& Objects.equals(name, agentInfo.name) && Objects.equals(email, agentInfo.email)
				&& Objects.equals(password, agentInfo.password) && Objects.equals(location, agentInfo.location)
				&& Objects.equals(id, agentInfo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idautogenerado, name, email, password, location, id, kind);
	}

}
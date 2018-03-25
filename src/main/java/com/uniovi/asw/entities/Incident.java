package com.uniovi.asw.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Incident {

	@Id
	@GeneratedValue
	private Long id;
	
	private Agent agent;

	private String incidentName;
	private String description;
	private String location;
	private Date date;

	private List<String> tags;
	private Map<String, String> aditionalProperties;
	private String topic;
	private IncidentStatus status;

	public enum IncidentStatus {
		OPEN, IN_PROCESS, CLOSED, CANCELLED
	};

	public Incident(Agent agent, String incidentName, String description, String location, Date date,
			ArrayList<String> tags, Map<String, String> aditionalProperties, String topic, IncidentStatus status) {
		this.agent = agent;
		this.incidentName = incidentName;
		this.description = description;
		this.location = location;
		this.date = date;
		this.tags = tags;
		this.aditionalProperties = aditionalProperties;
		this.topic = topic;
		this.status = status;
	}

	public Incident() {

	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getIncidentName() {
		return incidentName;
	}

	public void setIncidentName(String incidentName) {
		this.incidentName = incidentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getAditionalProperties() {
		return aditionalProperties;
	}

	public void setAditionalProperties(Map<String, String> aditionalProperties) {
		this.aditionalProperties = aditionalProperties;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public IncidentStatus getStatus() {
		return status;
	}

	public void setStatus(IncidentStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

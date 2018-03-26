package com.uniovi.asw.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.uniovi.asw.util.LatLng;

@Entity
public class Incident {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="agent_id")
	private Agent agent;

	private String incidentName;
	private String description;
	private LatLng location;
	private Date date;
	
	@ManyToOne
	private Operator operator;

	@ElementCollection(targetClass=String.class)
	private List<String> tags = new ArrayList<String>();
	
	@ElementCollection(targetClass=String.class)
	private Map<String, String> aditionalProperties = new HashMap<String, String>();
	
	private String topic;
	
	@Enumerated(EnumType.STRING)
	private IncidentStatus status;

	public enum IncidentStatus {
		OPEN, IN_PROCESS, CLOSED, CANCELLED
	};

	public Incident(Agent agent, String incidentName, String description, LatLng location, Date date,
			ArrayList<String> tags, Map<String, String> aditionalProperties, String topic, IncidentStatus status, 
			Operator operator) {
		this.agent = agent;
		this.incidentName = incidentName;
		this.description = description;
		this.location = location;
		this.date = date;
		this.tags = tags;
		this.aditionalProperties = aditionalProperties;
		this.topic = topic;
		this.status = status;
		this.operator = operator;
		operator.getIncidents().add(this);
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
	
	public Long getId() {
		return id;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
		this.location = location;
	}
	
	public boolean isAssignedTo(String username)
	{
		return (username.equals(operator.getUsername())) ? true : false;
	}

}

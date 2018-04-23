package com.uniovi.asw.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.uniovi.asw.util.LatLng;

@Document(collection = "incident_i1a_collection")
public class Incident {

	@Id
	private String idautogenerado;

	private Agent agent;
	private String incidentName;
	private String description;
	private List<String> tags = new ArrayList<String>();;
	private Operator operator;
	private String topic;
	private String locationString;
	private LatLng location;
	private Date date;
	private Map<String, String> aditionalProperties = new HashMap<String, String>();
	private String aditionalPropertiesString;
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
	}
	
	public Incident() {
		this.status=IncidentStatus.OPEN;
	}

	public String getIdautogenerado() {
		return idautogenerado;
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

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public String getAditionalPropertiesString() {
		return aditionalPropertiesString;
	}

	public void setAditionalPropertiesString(String aditionalPropertiesString) {
		this.aditionalPropertiesString = aditionalPropertiesString;
	}
	
	public boolean isAssignedTo(String username)
	{
		return (username.equals(operator.getUsername())) ? true : false;
	}

	@Override
	public String toString() {
		return "Incident [agent='" + agent + "', incidentName='" + incidentName + "', description='" + description
				+ "', tags='" + tags + "', operator='" + operator + "', topic='" + topic + "', locationString='"
				+ locationString + "', location='" + location + "', date='" + date + "', aditionalProperties='"
				+ aditionalProperties + "', aditionalPropertiesString='" + aditionalPropertiesString + "', status='"
				+ status + "']";
	}
	

}
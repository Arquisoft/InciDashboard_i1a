package com.uniovi.asw.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Agent;
import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.entities.Operator;

@Service
public class InsertSampleDataService {

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TopicService topicsService;

	@PostConstruct
	public void init() {
		
		// Adding some Operators
		Operator admin = new Operator("admin", "admin");
		Operator police = new Operator("police", "police");
		Operator firestation = new Operator("firestation", "firestation");
		operatorService.saveOperator(admin);
		operatorService.saveOperator(police);
		operatorService.saveOperator(firestation);
		
		// Adding some Agents
		Agent agent1 = new Agent("pepe", "123456", "43.271934,-6.610977");
		Agent agent2 = new Agent("maria", "123456", "43.348625,-5.127593");
		Agent agent3 = new Agent("juan", "123456", "43.170862,-5.176625");
		agentService.saveAgent(agent1);
		agentService.saveAgent(agent2);
		agentService.saveAgent(agent3);
		
		// Adding some Incidents
		
		/*
		 * Incident 1
		 */
		ArrayList<String> incident1Tags = new ArrayList<String>();
		incident1Tags.add("fire");
		incident1Tags.add("tineo");
		Map<String, String> incident1Props = new HashMap<String, String>();
		incident1Props.put("p1", "property1");
		incident1Props.put("p2", "property2");
		String topic1 = topicsService.getTopics()[1]; //fire
		Incident incident1 = new Incident(agent1, "Fire in Tineo", "Fire in a land near Tineo, Asturias.", 
				"43.311312,-6.415061", new Date(), incident1Tags,
				incident1Props, topic1, IncidentStatus.OPEN);
		incidentService.saveIncident(incident1);
		
		/*
		 * Incident 2
		 */
		ArrayList<String> incident2Tags = new ArrayList<String>();
		incident2Tags.add("accident");
		incident2Tags.add("mieres");
		Map<String, String> incident2Props = new HashMap<String, String>();
		incident2Props.put("p1", "property1");
		incident2Props.put("p2", "property2");
		String topic2 = topicsService.getTopics()[0]; //accident
		Incident incident2 = new Incident(agent3, "Car accident in Mieres", "Car crash at A-66 near Mieres, Asturias.", 
				"43.248067,-5.780542", new Date(), incident2Tags,
				incident2Props, topic2, IncidentStatus.IN_PROCESS);
		incidentService.saveIncident(incident2);
		
		/*
		 * Incident 3
		 */
		ArrayList<String> incident3Tags = new ArrayList<String>();
		incident3Tags.add("snow");
		incident3Tags.add("pajares");
		Map<String, String> incident3Props = new HashMap<String, String>();
		incident3Props.put("p1", "property1");
		incident3Props.put("p2", "property2");
		String topic3 = topicsService.getTopics()[4]; //metheorological phenomenon
		Incident incident3 = new Incident(agent2, "Thick snow in Pajares", "Thick snow and ice plates near Pajares port.", 
				"42.995561,-5.755010", new Date(), incident3Tags,
				incident3Props, topic3, IncidentStatus.IN_PROCESS);
		incidentService.saveIncident(incident3);
		
		/*
		 * Incident 4
		 */
		ArrayList<String> incident4Tags = new ArrayList<String>();
		incident4Tags.add("accident");
		incident4Tags.add("gijon");
		Map<String, String> incident4Props = new HashMap<String, String>();
		incident4Props.put("p1", "property1");
		incident4Props.put("p2", "property2");
		String topic4 = topicsService.getTopics()[0]; //accident
		Incident incident4 = new Incident(agent3, "Car accident in Gijon", "Car crash near Viesques, Gijon.", 
				"43.524733,-5.639690", new Date(), incident4Tags,
				incident4Props, topic4, IncidentStatus.CLOSED);
		incidentService.saveIncident(incident4);
		
		/*
		 * Incident 5
		 */
		ArrayList<String> incident5Tags = new ArrayList<String>();
		incident5Tags.add("fire");
		incident5Tags.add("aviles");
		Map<String, String> incident5Props = new HashMap<String, String>();
		incident5Props.put("p1", "property1");
		incident5Props.put("p2", "property2");
		String topic5 = topicsService.getTopics()[1]; //fire
		Incident incident5 = new Incident(agent2, "Fire in Aviles", "Fire in a shed near Aviles port.", 
				"43.575120,-5.925035", new Date(), incident5Tags,
				incident5Props, topic5, IncidentStatus.CLOSED);
		incidentService.saveIncident(incident5);
	}

}

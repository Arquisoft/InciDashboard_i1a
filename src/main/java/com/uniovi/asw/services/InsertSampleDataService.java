package com.uniovi.asw.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomStringUtils;
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
	
	private Random r = new Random();

	@PostConstruct
	public void init() {
		
		// Adding some Operators
		Operator admin = new Operator("admin", "admin");
		Operator police = new Operator("police", "police");
		Operator firestation = new Operator("firestation", "firestation");
		operatorService.saveOperator(admin);
		operatorService.saveOperator(police);
		operatorService.saveOperator(firestation);
		
//		// Adding some Agents
//		Agent agent1 = new Agent("pepe", "123456", "43.271934,-6.610977");
//		Agent agent2 = new Agent("maria", "123456", "43.348625,-5.127593");
//		Agent agent3 = new Agent("juan", "123456", "43.170862,-5.176625");
//		agentService.saveAgent(agent1);
//		agentService.saveAgent(agent2);
//		agentService.saveAgent(agent3);
//		
//		// Adding some Incidents
		
		/*
		 * Incident 1
		 */
//		ArrayList<String> incident1Tags = new ArrayList<String>();
//		incident1Tags.add("fire");
//		incident1Tags.add("tineo");
//		Map<String, String> incident1Props = new HashMap<String, String>();
//		incident1Props.put("p1", "property1");
//		incident1Props.put("p2", "property2");
//		String topic1 = topicsService.getTopics()[1]; //fire
//		Incident incident1 = new Incident(agent1, "Fire in Tineo", "Fire in a land near Tineo, Asturias.", 
//				"43.311312,-6.415061", new Date(), incident1Tags,
//				incident1Props, topic1, IncidentStatus.OPEN);
//		incidentService.saveIncident(incident1);
//		
//		/*
//		 * Incident 2
//		 */
//		ArrayList<String> incident2Tags = new ArrayList<String>();
//		incident2Tags.add("accident");
//		incident2Tags.add("mieres");
//		Map<String, String> incident2Props = new HashMap<String, String>();
//		incident2Props.put("p1", "property1");
//		incident2Props.put("p2", "property2");
//		String topic2 = topicsService.getTopics()[0]; //accident
//		Incident incident2 = new Incident(agent3, "Car accident in Mieres", "Car crash at A-66 near Mieres, Asturias.", 
//				"43.248067,-5.780542", new Date(), incident2Tags,
//				incident2Props, topic2, IncidentStatus.IN_PROCESS);
//		incidentService.saveIncident(incident2);
//		
//		/*
//		 * Incident 3
//		 */
//		ArrayList<String> incident3Tags = new ArrayList<String>();
//		incident3Tags.add("snow");
//		incident3Tags.add("pajares");
//		Map<String, String> incident3Props = new HashMap<String, String>();
//		incident3Props.put("p1", "property1");
//		incident3Props.put("p2", "property2");
//		String topic3 = topicsService.getTopics()[4]; //metheorological phenomenon
//		Incident incident3 = new Incident(agent2, "Thick snow in Pajares", "Thick snow and ice plates near Pajares port.", 
//				"42.995561,-5.755010", new Date(), incident3Tags,
//				incident3Props, topic3, IncidentStatus.IN_PROCESS);
//		incidentService.saveIncident(incident3);
//		
//		/*
//		 * Incident 4
//		 */
//		ArrayList<String> incident4Tags = new ArrayList<String>();
//		incident4Tags.add("accident");
//		incident4Tags.add("gijon");
//		Map<String, String> incident4Props = new HashMap<String, String>();
//		incident4Props.put("p1", "property1");
//		incident4Props.put("p2", "property2");
//		String topic4 = topicsService.getTopics()[0]; //accident
//		Incident incident4 = new Incident(agent3, "Car accident in Gijon", "Car crash near Viesques, Gijon.", 
//				"43.524733,-5.639690", new Date(), incident4Tags,
//				incident4Props, topic4, IncidentStatus.CLOSED);
//		incidentService.saveIncident(incident4);
//		
//		/*
//		 * Incident 5
//		 */
//		ArrayList<String> incident5Tags = new ArrayList<String>();
//		incident5Tags.add("fire");
//		incident5Tags.add("aviles");
//		Map<String, String> incident5Props = new HashMap<String, String>();
//		incident5Props.put("p1", "property1");
//		incident5Props.put("p2", "property2");
//		String topic5 = topicsService.getTopics()[1]; //fire
//		Incident incident5 = new Incident(agent2, "Fire in Aviles", "Fire in a shed near Aviles port.", 
//				"43.575120,-5.925035", new Date(), incident5Tags,
//				incident5Props, topic5, IncidentStatus.CLOSED);
//		incidentService.saveIncident(incident5);
		
		Agent agent1 = new Agent("pepe", "123456", "43.271934,-6.610977");
		Agent agent2 = new Agent("maria", "123456", "43.348625,-5.127593");
		Agent agent3 = new Agent("juan", "123456", "43.170862,-5.176625");
		agentService.saveAgent(agent1);
		agentService.saveAgent(agent2);
		agentService.saveAgent(agent3);
		List<Agent> agents = new ArrayList<Agent>();
		agents.add(agent3);
		agents.add(agent2);
		agents.add(agent1);
		
		generateRandomIncidents(50, 5, 5, agents);
	}
	
	private void generateRandomIncidents(int numINcidents, int numTags, int numAddProp, List<Agent> agents) {
		for(int i=0; i < numINcidents; i++) {
			Agent agent = pickRandomAgent(agents);
			String incidentName = RandomStringUtils.randomAlphabetic(9);
			String incidentDescription = RandomStringUtils.randomAlphabetic(20);
			double Y = 36 + Math.random() * (43 - 36);
			double X = -9 + Math.random() * (3 + 9);
			String location = String.valueOf(Y)+","+String.valueOf(X);
			Date date = new Date();
			ArrayList<String> tags = new ArrayList<String>();
			tags = generateRandomTags(numTags);
			Map<String, String> additionalProperties = generateRandomAddProperties(numAddProp);
			String[] topics = topicsService.getTopics();
			String topic = topics[r.nextInt(6)];
			
			List<IncidentStatus> values =
					Collections.unmodifiableList(Arrays.asList(IncidentStatus.values()));
			int size = values.size();
			IncidentStatus status = values.get(r.nextInt(size));
			
			Incident incident = new Incident(agent, incidentName, incidentDescription, location,
					date, tags, additionalProperties, topic,status);
			incidentService.saveIncident(incident);
		}
	}
	
	private Agent pickRandomAgent(List<Agent> agents) {
		int numAgent = r.nextInt(3);
		return agents.get(numAgent);
	}
	
	private ArrayList<String> generateRandomTags(int numTags) {
		ArrayList<String> tags = new ArrayList<String>();
		for(int i=0; i < numTags; i++) {
			tags.add(RandomStringUtils.randomAlphabetic(5));
		}
		return tags;
	}
	
	private Map<String, String> generateRandomAddProperties(int num){
		Map<String, String> prop = new HashMap<String,String>();
		for(int i=0; i < num; i++) {
			prop.put("p"+i, RandomStringUtils.randomAlphabetic(8));
		}
		return prop;
	}

}

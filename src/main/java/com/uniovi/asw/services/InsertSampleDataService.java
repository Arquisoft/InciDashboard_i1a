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
import com.uniovi.asw.util.LatLng;

@Service
public class InsertSampleDataService {

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private IncidentService incidentService;

	@Autowired
	private TopicService topicsService;
	
	@Autowired
	private AgentService agentService;

	private Random r = new Random();

	@PostConstruct
	public void init() {
		
		if (!operatorService.getOperators().isEmpty()) {
			for (Operator o : operatorService.getOperators()) {
				operatorService.deleteOperator(o);
			}
		}
		
		if (!incidentService.getIncidents().isEmpty()) {
			for (Incident i : incidentService.getIncidents()) {
				incidentService.delete(i);
			}
		}
		
		// Adding some Operators
		Operator admin = new Operator("admin", "admin");
		Operator police = new Operator("police", "police");
		Operator firestation = new Operator("firestation", "firestation");
		operatorService.saveOperator(admin);
		operatorService.saveOperator(police);
		operatorService.saveOperator(firestation);

		// Adding some Incidents randomly
		// 50 incidents, 5 tags, 5 aditional props. using existing agents
		List<Agent> agents = agentService.getAgents();
		generateRandomIncidents(10, 5, 5, agents);
	}

	private void generateRandomIncidents(int numINcidents, int numTags, int numAddProp, List<Agent> agents) {
		for (int i = 0; i < numINcidents; i++) {
			Agent agent = pickRandomAgent(agents);
			String incidentName = RandomStringUtils.randomAlphabetic(9);
			String incidentDescription = RandomStringUtils.randomAlphabetic(20);
			double lat = 36 + Math.random() * (43 - 36);
			double lng = -9 + Math.random() * (3 + 9);
			LatLng location = new LatLng(lat, lng);
			Date date = new Date();
			ArrayList<String> tags = new ArrayList<String>();
			tags = generateRandomTags(numTags);
			Map<String, String> additionalProperties = generateRandomAddProperties(numAddProp);
			String[] topics = topicsService.getTopics();
			String topic = topics[r.nextInt(6)];
			List<Operator> operators = operatorService.getOperators();
			Random r = new Random();
			Operator operatorAssigned = operators.get(r.nextInt(operators.size()));

			List<IncidentStatus> values = Collections.unmodifiableList(Arrays.asList(IncidentStatus.values()));
			int size = values.size();
			IncidentStatus status = values.get(r.nextInt(size));

			Incident incident = new Incident(agent, incidentName, incidentDescription, location, date, tags,
					additionalProperties, topic, status, operatorAssigned);
			incidentService.saveIncident(incident);
		}
	}

	private Agent pickRandomAgent(List<Agent> agents) {
		int numAgent = r.nextInt(3);
		return agents.get(numAgent);
	}

	private ArrayList<String> generateRandomTags(int numTags) {
		ArrayList<String> tags = new ArrayList<String>();
		for (int i = 0; i < numTags; i++) {
			tags.add(RandomStringUtils.randomAlphabetic(5));
		}
		return tags;
	}

	private Map<String, String> generateRandomAddProperties(int num) {
		Map<String, String> prop = new HashMap<String, String>();
		for (int i = 0; i < num; i++) {
			prop.put("p" + i, RandomStringUtils.randomAlphabetic(8));
		}
		return prop;
	}
	

}
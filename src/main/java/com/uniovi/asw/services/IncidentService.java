package com.uniovi.asw.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.entities.Operator;
import com.uniovi.asw.repositories.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository incidentRepository;

	@Autowired
	private TopicService topicsService;
	
	@Autowired
	private OperatorService operatorService;

	public void saveIncident(Incident incident) {
		incidentRepository.save(incident);
	}

	public List<Incident> getIncidents() {
		return incidentRepository.findAll();
	}
	
	
	public List<Incident> getByTopic(String topic)
	{
		return incidentRepository.findByTopic(topic);
	}

	public Incident getIncidentById(String id) {
		return incidentRepository.findByIdautogenerado(id);
	}

	public void delete(Incident i) {
		incidentRepository.delete(i);
	}
	
	public Map<String, Integer> getCountByTopic(List<Incident> incidentsList) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		String[] topics = topicsService.getTopics();
		count.put(topics[0], 0);
		count.put(topics[1], 0);
		count.put(topics[2], 0);
		count.put(topics[3], 0);
		count.put(topics[4], 0);
		count.put(topics[5], 0);
		for (Incident i : incidentsList) {
			int countUntilNow = count.get(i.getTopic());
			countUntilNow++;
			count.put(i.getTopic(), countUntilNow);
		}
		return count;
	}

	public Map<String, Integer> getCountByStatus(List<Incident> incidentsList) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		IncidentStatus[] status = IncidentStatus.values();
		count.put(status[0].name(), 0);
		count.put(status[1].name(), 0);
		count.put(status[2].name(), 0);
		count.put(status[3].name(), 0);
		for (Incident i : incidentsList) {
			int countUntilNow = count.get(i.getStatus().name());
			countUntilNow++;
			count.put(i.getStatus().name(), countUntilNow);
		}
		return count;
	}

	public void assingOperator(Incident i) {
		Operator admin = operatorService.getOperator("admin");
		Operator police = operatorService.getOperator("police");
		Operator fireman = operatorService.getOperator("fireman");
		Operator doctor = operatorService.getOperator("doctor");
		
		switch (i.getTopic()) {
			case "OTHER":
				i.setOperator(admin);
				break;
			case "FIRE":
				i.setOperator(fireman);
				break;
			case "METEREOLOGICAL_PHENOMENON":
				i.setOperator(fireman);
				break;
			case "ACCIDENT":
				i.setOperator(police);
				break;
			case "ALTERCATION":
				i.setOperator(police);
				break;
			case "MEDICAL_EMERGENCY":
				i.setOperator(doctor);
				break;
				
		}
	}
}
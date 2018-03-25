package com.uniovi.asw.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.repositories.IncidentRepository;

@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private TopicService topicsService;

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

	public Map<String, Integer> getCountByTopic(List<Incident> incidentsList) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		String[] topics = topicsService.getTopics();
		count.put(topics[0], 0);
		count.put(topics[1], 0);
		count.put(topics[2], 0);
		count.put(topics[3], 0);
		count.put(topics[4], 0);
		count.put(topics[5], 0);
		for (Incident i : incidentsList)
		{
			int countUntilNow = count.get(i.getTopic());
			countUntilNow++;
			count.put(i.getTopic(), countUntilNow);
		}
		return count;
	}

}

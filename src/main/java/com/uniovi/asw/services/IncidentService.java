package com.uniovi.asw.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.listeners.IncidentListener;
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
		IncidentListener lis = new IncidentListener();
		List<Incident> incidents = lis.getIncidents();
		incidents.addAll(incidentRepository.findAll());
		return incidents;
	}
	
	public Page<Incident> getPageIncidents(Pageable pageable)
	{
		return incidentRepository.findAll(pageable);
	}
	
	public List<Incident> getByTopic(String topic)
	{
		return incidentRepository.findByTopic(topic);
	}

	public Incident getIncidentById(Long id) {
		return incidentRepository.findById(id);
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

}

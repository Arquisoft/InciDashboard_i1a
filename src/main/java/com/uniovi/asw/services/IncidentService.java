package com.uniovi.asw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.repositories.IncidentRepository;

@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;

	public void saveIncident(Incident incident) {
		incidentRepository.save(incident);
	}

	public List<Incident> getIncidents() {
		return incidentRepository.findAll();
	}

}

package com.uniovi.asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.repositories.IncidentRepository;
import com.uniovi.asw.util.LatLng;

@Service
public class CargarIncidentesEnMapa {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	public List<LatLng> localizaciones(){
		List<Incident> incidentes = incidentRepository.findAll();
		List<LatLng> localizaciones = new ArrayList<LatLng>();
		for(Incident i: incidentes) {
			localizaciones.add(i.getLocation());
		}
		
		return localizaciones;
	}

}

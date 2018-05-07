package com.uniovi.asw.listeners;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.ManagedBean;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.services.IncidentService;


@ManagedBean
public class IncidentListener {
	// ACCIDENT FIRE ALTERCATION MEDICAL_EMERGENCY METEREOLOGICAL_PHENOMENON OTHER
	Properties props = new Properties();

	@Autowired
	private IncidentService incidentService;	

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	private static final Logger logger = Logger.getLogger(IncidentListener.class);

	@KafkaListener(topics = "ACCIDENT")
	public void listenAccident(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	@KafkaListener(topics = "FIRE")
	public void listenFire(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	@KafkaListener(topics = "ALTERCATION")
	public void listenAltercation(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	@KafkaListener(topics = "MEDICAL_EMERGENCY")
	public void listenMedical(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	@KafkaListener(topics = "METEOROLOGICAL_PHENOMENON")
	public void listenMeteo(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	@KafkaListener(topics = "OTHER")
	public void listenOther(String data) {
		logger.info("New message received: \"" + data + "\"");
		saveIncidentFromKafka(data);
	}

	private void saveIncidentFromKafka(String data) {
		try {
			if(data != null && data.length() != 0) {
				ObjectMapper obj = new ObjectMapper();
				Incident incident = obj.readValue(data.getBytes(), Incident.class);
				incident.setStatus(IncidentStatus.OPEN);
				incidentService.assingOperator(incident);
				incidentService.saveIncident(incident);
				messagingTemplate.convertAndSend("/incident", incident);
			}
		} catch(JsonParseException e) {
			e.printStackTrace();			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
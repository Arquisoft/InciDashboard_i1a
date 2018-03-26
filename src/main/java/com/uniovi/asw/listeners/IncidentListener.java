package com.uniovi.asw.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.annotation.ManagedBean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.repositories.IncidentRepository;


/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class IncidentListener {
	// ACCIDENT FIRE ALTERCATION MEDICAL_EMERGENCY METEREOLOGICAL_PHENOMENON OTHER
	Properties props = new Properties();
	List<Incident> incidents = new ArrayList<Incident>();
	
	@Autowired
	private IncidentRepository incidentsRepository;
	

	private static final Logger logger = Logger.getLogger(IncidentListener.class);
	
	private void getData(String topic) {
		props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.deserializer", "com.uniovi.asw.parser.IncidentDeserializer");
		props.put("value.deserializer", "com.uniovi.asw.parser.IncidentDeserializer");
		props.put("bootstrap.servers","localhost:9092");
		try (KafkaConsumer<String, Incident> consumer = new KafkaConsumer<>(props)) {
			consumer.subscribe(Collections.singletonList(topic));
			while (true) {
				ConsumerRecords<String, Incident> messages = consumer.poll(100);
				for (ConsumerRecord<String, Incident> message : messages) {
					incidentsRepository.save(message.value());
					System.out.println("Message received " + message.value().toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@KafkaListener(topics = "ACCIDENT")
	public void listenAccident(String data) {
		getData("ACCIDENT");
	}

	@KafkaListener(topics = "FIRE")
	public void listenFire(String data) {
		getData("FIRE");
	}

	@KafkaListener(topics = "ALTERCATION")
	public void listenAltercation(String data) {
		getData("ALTERCATION");
	}

	@KafkaListener(topics = "MEDICAL_EMERGENCY")
	public void listenMedical(String data) {
		getData("MEDICAL_EMERGENCY");
	}

	@KafkaListener(topics = "METEREOLOGICAL_PHENOMENON")
	public void listenMeteo(String data) {
		getData("METEREOLOGICAL_PHENOMENON");
	}

	@KafkaListener(topics = "OTHER")
	public void listenOther(String data) {
		getData("OTHER");
	}

	public List<Incident> getIncidents() {
		return incidents;
	}

}

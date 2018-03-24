package com.uniovi.asw.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import com.uniovi.asw.entities.Message;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {
	// ACCIDENT FIRE ALTERCATION MEDICAL_EMERGENCY METEREOLOGICAL_PHENOMENON OTHER
	List<Message> messages = new ArrayList<Message>();
	private static final Logger logger = Logger.getLogger(MessageListener.class);

	@KafkaListener(topics = "ACCIDENT")
	public void listenAccident(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "ACCIDENT"));
	}

	@KafkaListener(topics = "FIRE")
	public void listenFire(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "FIRE"));
	}

	@KafkaListener(topics = "ALTERCATION")
	public void listenAltercation(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "ALTERCATION"));
	}

	@KafkaListener(topics = "MEDICAL_EMERGENCY")
	public void listenMedical(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "MEDICAL_EMERGENCY"));
	}

	@KafkaListener(topics = "METEREOLOGICAL_PHENOMENON")
	public void listenMeteo(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "METEOROLOGICAL_PHENOMENON"));
	}

	@KafkaListener(topics = "OTHER")
	public void listenOther(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(new Message(data, "OTHER"));
	}

	public List<Message> getMessages() {
		return messages;
	}

}

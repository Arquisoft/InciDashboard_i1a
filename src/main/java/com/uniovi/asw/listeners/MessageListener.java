package com.uniovi.asw.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {

	List<String> messages = new ArrayList<String>();
	private static final Logger logger = Logger.getLogger(MessageListener.class);

	@KafkaListener(topics = "exampleTopic")
	public void listen(String data) {
		logger.info("New message received: \"" + data + "\"");
		messages.add(data);
	}

	public List<String> getMessages() {
		return messages;
	}

}

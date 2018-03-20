package com.uniovi.entities;

public class Message {
	Long id;
	String message;
	String topic;

	Message() {

	}

	public Message(String msg, String topic) {
		super();
		this.message = msg;
		this.topic = topic;
	}
}

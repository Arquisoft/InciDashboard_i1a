package com.uniovi.asw.parser;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.asw.entities.Incident;

public class IncidentDeserializer implements Deserializer<Incident> {
	
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {

	}

	@Override
	public Incident deserialize(String arg0, byte[] arg1) {
		ObjectMapper mapper = new ObjectMapper();
		Incident inci = null;
		try {
			inci = mapper.readValue(arg1, Incident.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inci;
	}

}

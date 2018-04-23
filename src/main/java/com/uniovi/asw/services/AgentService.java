package com.uniovi.asw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Agent;
import com.uniovi.asw.repositories.AgentRepository;

@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	public List<Agent> getAgents()
	{
		return agentRepository.findAll();
	}
	
}
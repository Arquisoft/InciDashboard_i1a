package com.uniovi.asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Agent;
import com.uniovi.asw.repositories.AgentRepository;

@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void saveAgent(Agent agent) {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		agentRepository.save(agent);
	}

	public void saveAgentIfNotExist(Agent agent) {
		//Long id = Long.parseLong(agent.getId());
		Agent a = agentRepository.findOne(agent.getId());
		if (a == null)
			agentRepository.save(agent);
	}
}

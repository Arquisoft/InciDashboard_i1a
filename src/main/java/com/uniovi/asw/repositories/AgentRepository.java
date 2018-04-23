package com.uniovi.asw.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.asw.entities.Agent;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
	Agent findById(String id);
	List<Agent> findAll();
}
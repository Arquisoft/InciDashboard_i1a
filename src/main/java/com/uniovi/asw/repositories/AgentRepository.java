package com.uniovi.asw.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.asw.entities.Agent;

public interface AgentRepository extends CrudRepository<Agent, String>{

	@Query("Select a from Agent a Where a.id=?1")
	Agent findOne(String id);

}

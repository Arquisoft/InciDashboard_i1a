package com.uniovi.asw.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.uniovi.asw.entities.Incident;

@Repository
public interface IncidentRepository extends MongoRepository<Incident,Long>{
	public List<Incident> findAll();
	public List<Incident> findByTopic(String topic);
    @Query("{'agent.id' : '?0'} }")
    List<Incident> findByAgentID(String id);
    public Incident findByIdautogenerado(String id);
}
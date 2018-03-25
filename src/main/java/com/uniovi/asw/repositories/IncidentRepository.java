package com.uniovi.asw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.asw.entities.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
	public List<Incident> findAll();
}

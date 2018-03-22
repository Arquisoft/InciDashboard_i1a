package com.uniovi.asw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uniovi.asw.entities.Operator;

public interface OperatorRepository extends MongoRepository<Operator, String>{

	Operator findByUsername(String username);
	
}

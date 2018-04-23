package com.uniovi.asw.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uniovi.asw.entities.Operator;

public interface OperatorRepository extends MongoRepository<Operator, Long> {

	Operator findByUsername(String username);
	List<Operator> findAll();

}
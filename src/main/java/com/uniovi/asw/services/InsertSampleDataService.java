package com.uniovi.asw.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Operator;
import com.uniovi.asw.repositories.OperatorRepository;

@Service
public class InsertSampleDataService {

	@Autowired
	private OperatorRepository operatorRepository;
	
	
	@PostConstruct
	public void init()
	{
		Operator admin = new Operator("admin", "admin");
		operatorRepository.save(admin);
	}
	
}

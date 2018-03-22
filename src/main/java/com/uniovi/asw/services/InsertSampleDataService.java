package com.uniovi.asw.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Operator;

@Service
public class InsertSampleDataService {

	@Autowired
	private OperatorService operatorService;
	
	
	@PostConstruct
	public void init()
	{
		Operator admin = new Operator("admin", "admin");
		operatorService.saveOperator(admin);
	}
	
}

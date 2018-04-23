package com.uniovi.asw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.asw.entities.Operator;
import com.uniovi.asw.repositories.OperatorRepository;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository operatorRepository;
	
	
	public void saveOperator(Operator operator) {
		operator.setPassword(operator.getPassword());
		operatorRepository.save(operator);
	}
	
	public List<Operator> getOperators()
	{
		return operatorRepository.findAll();
	}

	public void deleteOperator(Operator o) {
		operatorRepository.delete(o);
	}
	
	public Operator getOperator(String username)
	{
		return operatorRepository.findByUsername(username);
	}
}
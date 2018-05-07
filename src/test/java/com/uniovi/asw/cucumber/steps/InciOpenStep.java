package com.uniovi.asw.cucumber.steps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.entities.Operator;
import com.uniovi.asw.services.IncidentService;
import com.uniovi.asw.services.OperatorService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InciOpenStep {
	
	@Autowired
	OperatorService operatorService;
	
	@Autowired
	IncidentService incidentService;
	
	private Operator operator;
	private Incident incident;
	
	@Given("^an operator logged in the system")
	public void getOperator() {
		operator = operatorService.getOperators().get(1);
	}
	
	@And("^one assigned incident")
	public void getAssignedIncident() {
		List<Incident> inciList = incidentService.getIncidents();
		for (Incident i : inciList) {
			if (i.getOperator().equals(operator.getUsername())) {
				incident = i;
			}
		}
	}
	
	@When("^changes the incident status to open$")
	public void changeStatusOpen() {
		incident.setStatus(IncidentStatus.OPEN);
	}
	
	@Then("^the incident is open$")
	public void checkStatusOpen() {
		if (incident.getStatus().equals(IncidentStatus.OPEN)) {
			System.out.println("Cucumber incident status open test passed correctly.");
		} else {
			System.out.println("Cucumber incident status open failed.");
		}
	}
}

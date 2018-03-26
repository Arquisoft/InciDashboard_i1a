package com.uniovi.asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.asw.services.IncidentService;

@Controller
public class IncidentController {

	@Autowired
	private IncidentService incidentService;
	
	@RequestMapping("/incident/details/{id}")
	public String getDetails(Model model, @PathVariable Long id) {
		return "incident/details";
	}

}

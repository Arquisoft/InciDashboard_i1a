package com.uniovi.asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.uniovi.asw.services.IncidentService;

@Controller
public class IncidentController {

	@Autowired
	private IncidentService incidentService;

}

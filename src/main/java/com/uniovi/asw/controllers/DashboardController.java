package com.uniovi.asw.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.services.IncidentService;

@Controller
public class DashboardController {
	
	@Autowired
	private IncidentService incidentService;

	@RequestMapping("/dashboard")
	public String landing(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUser = auth.getName();
		
		List<Incident> incidentsList = incidentService.getIncidents();
		
		Map<String, Integer> countIncidents = incidentService.getCountByTopic(incidentsList);
		Map<String, Integer> countStatus = incidentService.getCountByStatus(incidentsList);
		
		model.addAttribute("incidentsList", incidentsList);
		model.addAttribute("loggedUser", loggedUser);
		model.addAttribute("countIncidents", countIncidents);
		model.addAttribute("countStatus", countStatus);
		return "dashboard";
	}

}
package com.uniovi.asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.services.IncidentService;

@Controller
public class IncidentController {

	@Autowired
	private IncidentService incidentService;
	
	@RequestMapping("/incident/details/{id}")
	public String getDetails(Model model, @PathVariable String id) {
		Incident incident = incidentService.getIncidentById(id);
		model.addAttribute("incident", incident);
		return "incident/details";
	}
	
	@RequestMapping(value = "/incident/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable String id) {
		Incident incident = incidentService.getIncidentById(id);
		model.addAttribute("incident", incident);
		return "incident/edit";
	}
	
	@RequestMapping(value = "/incident/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, @PathVariable String id, @RequestParam String incStatus) {
		Incident originalInc = incidentService.getIncidentById(id);
		originalInc.setStatus(IncidentStatus.valueOf(incStatus));
		incidentService.saveIncident(originalInc);
		return "redirect:/dashboard";
	}
}
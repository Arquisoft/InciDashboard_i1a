package com.uniovi.asw.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.asw.entities.Message;
import com.uniovi.asw.listeners.MessageListener;

@Controller
public class MainController {

	@Autowired
	private MessageListener listener;

	private static Map<String, Integer> counter;
	private static final Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping("/")
	public String landing(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUser = auth.getName();
		List<Message> list = listener.getMessages();
		counter = new HashMap<String, Integer>();
		for (Message m : list) {
			if (counter.get(m.getTopic()) == null) {
				counter.put(m.getTopic(), 1);
			} else {
				int value = counter.get(m.getTopic());
				counter.put(m.getTopic(), value++);
			}
		}
		model.addAttribute("messages", list);
		model.addAttribute("loggedUser", loggedUser);
		return "index";
	}

}
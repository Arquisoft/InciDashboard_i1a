package com.uniovi.asw;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.asw.listeners.MessageListener;

@Controller
public class MainController {

	@Autowired
	private MessageListener listener;

	private static final Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("messages", listener.getMessages());
		return "index";
	}

}
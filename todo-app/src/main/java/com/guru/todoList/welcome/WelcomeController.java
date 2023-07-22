package com.guru.todoList.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WelcomeController {
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", welcomeService.getLoggedInUsername());
		return "welcome";
	}

}

package com.nagarro.javaTraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout {

	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getlogin() {
		ModelAndView modelAndView = new ModelAndView("login");
	
		return modelAndView;
	}
}

package com.nagarro.javaTraining.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javaTraining.model.Employee;

@Controller
public class EmployeeDetails {
	
	@RequestMapping(value = "/employeeDetails", method = RequestMethod.GET)
	public ModelAndView getlogin() {
		EmployeeManagementServiceImpl impl=new EmployeeManagementServiceImpl();
		List<Employee> empList= impl.getListOfEmployees();
		ModelAndView modelAndView = new ModelAndView("EmployeeDetails");
		modelAndView.addObject("list", empList);
		return modelAndView;
	}

}

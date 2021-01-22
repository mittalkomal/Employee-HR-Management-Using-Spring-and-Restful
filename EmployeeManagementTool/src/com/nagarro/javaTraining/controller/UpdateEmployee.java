package com.nagarro.javaTraining.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javaTraining.model.Employee;

@Controller
@SessionAttributes("successMsg")
public class UpdateEmployee {

	@RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult result) {
		EmployeeManagementServiceImpl impl = new EmployeeManagementServiceImpl();
	    impl.updateEmployee("1", employee);
	    
		ModelAndView modelAndView = new ModelAndView("redirect:employeeDetails");
		modelAndView.addObject("successMsg", "Data updated Successfully");
		return modelAndView;
	}

}

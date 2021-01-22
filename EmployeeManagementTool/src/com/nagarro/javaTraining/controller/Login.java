package com.nagarro.javaTraining.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.nagarro.javaTraining.dao.UserDao;
import com.nagarro.javaTraining.model.LoginDetails;
import com.nagarro.javaTraining.model.User;
import com.nagarro.javaTraining.utils.AppContextUtil;

@Controller
@SessionAttributes("loginedUser")
public class Login {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getlogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value ="/login" , method=RequestMethod.POST)
	public ModelAndView provideLogin(@Valid @ModelAttribute("loginDetails") LoginDetails loginDetails,BindingResult result){
		
		ModelAndView modelAndView = new ModelAndView("login") ;
		if(result.hasErrors())
		{
			return modelAndView ;
		}
		
		UserDao obj = (UserDao)AppContextUtil.context.getBean("userdao");
		User userMain =  (User)obj.getUser(loginDetails.getUserId());
		if(userMain==null)
		{
			ObjectError error = new ObjectError("loginError", "No such User Exists");
			result.addError(error);
			modelAndView.addObject("InvalidationMsg", "No such User Exists");
			return modelAndView ;
		}
		else if (!userMain.getPass().equals(loginDetails.getPass()))
		{
			ObjectError error = new ObjectError("loginError", "Password is incorrect");
			result.addError(error);
			modelAndView.addObject("InvalidationMsg", "Password is incorrect");
			return modelAndView ;
		}
		
		
		modelAndView = new ModelAndView("redirect:employeeDetails") ;
		modelAndView.addObject("loginedUser", userMain.getFullName());
		return modelAndView ;
	}
}

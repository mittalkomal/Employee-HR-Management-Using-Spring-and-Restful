package com.nagarro.javaTraining.controller;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javaTraining.model.Employee;

@Controller
@SessionAttributes("successMsg")
public class UploadEmployeeDetails {

	@RequestMapping(value = "/uploadEmployeeDetails", method = RequestMethod.POST)
	public ModelAndView uploadDetails(@RequestParam("csvFile") MultipartFile csvFile) {

		try {
			String line = "";
			String splitBy = ";";
			BufferedReader br = new BufferedReader(new FileReader(csvFile.getOriginalFilename()));
			while ((line = br.readLine()) != null) {
				String[] empDetails = line.split(splitBy);
				if (empDetails.length > 0) {
					Employee empData = new Employee();
					empData.setEmployeeCode(Integer.parseInt(empDetails[0]));
					empData.setName(empDetails[1]);
					empData.setDob(empDetails[2]);
					empData.setEmail(empDetails[3]);
					empData.setLocation(empDetails[4]);

					EmployeeManagementServiceImpl impl = new EmployeeManagementServiceImpl();
					impl.saveEmployee(empData);
					ModelAndView modelAndView = new ModelAndView("redirect:employeeDetails");
						
					return modelAndView;

				}

			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
			ModelAndView modelAndView = new ModelAndView("redirect:employeeDetails");
			modelAndView.addObject("successMsg", "Data uploaded successfully");
			return modelAndView;
		} finally {
			
		}

		return null;
	}
}

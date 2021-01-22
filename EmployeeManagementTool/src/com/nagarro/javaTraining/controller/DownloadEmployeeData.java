package com.nagarro.javaTraining.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javaTraining.constants.Constants;
import com.nagarro.javaTraining.model.Employee;

@Controller

public class DownloadEmployeeData {

	@RequestMapping(value = "/downloadEmployeeData", method = RequestMethod.GET)
	public ModelAndView downloadDetails(HttpServletResponse response) {

		try {

			String filePath = createCSVFromDataBase();
			File file = null;
			file = new File(filePath);
			if (!file.exists()) {
				System.err.println("Sorry. The file you are looking for does not exist");
			}
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				System.out.println("mimetype is not detectable, will take default");
				mimeType = "application/octet-stream";
			}
			System.out.println("mimetype : " + mimeType);
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
			response.setContentLength((int) file.length());
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {

		System.err.println("Some error occured while downloading file, please try again");
		}
		return null;

	}

	private String createCSVFromDataBase() {
		try {
			FileWriter csvWriter = new FileWriter(Constants.TEMP_CSV_PATH + "emp4.csv");
			EmployeeManagementServiceImpl service = new EmployeeManagementServiceImpl();
			List<Employee> empList = service.getListOfEmployees();
			for (Employee emp : empList) {
				csvWriter.append(emp.getEmployeeCode() + "," + emp.getName() + "," + emp.getDob() + "," + emp.getEmail()
						+ "," + emp.getLocation());
				csvWriter.append("\n");
			}
			csvWriter.flush();
			csvWriter.close();
			return Constants.TEMP_CSV_PATH + "emp4.csv";
		} catch (Exception e) {

		}
		return Constants.TEMP_CSV_PATH + "emp4.csv";
	}

}

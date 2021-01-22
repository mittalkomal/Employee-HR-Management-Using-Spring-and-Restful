package com.nagarro.javaTraining.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.javaTraining.model.Employee;

public class EmployeeManagementServiceImpl {

	public List<Employee> getListOfEmployees() {
		WebTarget target = getWebTarget();
		String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		while (response == null || response.length() == 0) {
			response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		try {
			List<Employee> participantJsonList = mapper.readValue(response, new TypeReference<List<Employee>>() {
			});
			return participantJsonList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	static WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		return client.target(com.nagarro.javaTraining.constants.Constants.BASE_URI);
	}

	public void updateEmployee(String id, Employee employee) {
		WebTarget target = getWebTarget();
		Response response = target.path(id).request().put(Entity.entity(employee, MediaType.APPLICATION_JSON),
				Response.class);
		System.out.println(response);
	}

	public void saveEmployee(Employee emp) {
		WebTarget target = getWebTarget();
		Response response = target.request().post(Entity.entity(emp, MediaType.APPLICATION_JSON), Response.class);

		System.out.println(response.getLocation().toString());
	}

}

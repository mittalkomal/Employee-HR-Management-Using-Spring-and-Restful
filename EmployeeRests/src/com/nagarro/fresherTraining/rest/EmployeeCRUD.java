package com.nagarro.fresherTraining.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nagarro.fresherTraining.dao.EmployeeDao;
import com.nagarro.fresherTraining.daoImpl.EmployeeDaoImpl;
import com.nagarro.fresherTraining.model.Employee;

@Path("/employee")
public class EmployeeCRUD {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
        EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> empList = dao.getListOfUser();

		return empList;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") int id, Employee employee) {
		 EmployeeDao dao = new EmployeeDaoImpl();
		 dao.updateEmployee(id, employee);
		return Response.notModified().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Employee employee) throws URISyntaxException {
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.saveEmployee( employee);
		return Response.ok().build();
	}

}

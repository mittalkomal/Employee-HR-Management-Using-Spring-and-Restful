package com.nagarro.fresherTraining.dao;

import java.util.List;

import com.nagarro.fresherTraining.model.Employee;

public interface EmployeeDao {
	/*
	 * Method to get list of employees
	 * 
	 * @return List<Employee>
	 */

	public List<Employee> getListOfUser();

	/*
	 * Method to update employee
	 * 
	 * @param id, Employee emp
	 */
	public void updateEmployee(int id, Employee emp);

	/*
	 * Method to save employee
	 * 
	 * @param Employee emp
	 */
	public void saveEmployee(Employee emp);
}

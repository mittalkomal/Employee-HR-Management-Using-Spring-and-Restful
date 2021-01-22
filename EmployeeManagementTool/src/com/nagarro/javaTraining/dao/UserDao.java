package com.nagarro.javaTraining.dao;

import com.nagarro.javaTraining.model.User;

public interface UserDao {

	/*
	 * Method used to save user
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/*
	 * Method to get user
	 * 
	 * @param userId
	 * 
	 * @returns user
	 */
	public User getUser(String userId);
}

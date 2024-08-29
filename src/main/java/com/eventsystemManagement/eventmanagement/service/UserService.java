package com.eventsystemManagement.eventmanagement.service;

import com.eventsystemManagement.eventmanagement.model.User;

public interface UserService {

	User registerUser(User user);
	
	User getUserByUsername(String username);
	
	boolean authenticateUser(String username, String password);
}

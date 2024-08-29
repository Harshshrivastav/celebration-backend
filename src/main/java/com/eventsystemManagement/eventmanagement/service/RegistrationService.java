package com.eventsystemManagement.eventmanagement.service;

import java.util.List;

import com.eventsystemManagement.eventmanagement.model.Registration;
import com.eventsystemManagement.eventmanagement.model.User;

public interface RegistrationService {

	Registration registerForEvent(Long id, Long userId);

	List<User> getAttendeesForEvent(Long id);
	
}

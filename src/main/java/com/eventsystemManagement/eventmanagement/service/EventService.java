package com.eventsystemManagement.eventmanagement.service;

import java.util.*;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.eventsystemManagement.eventmanagement.dto.EventDto;
import com.eventsystemManagement.eventmanagement.model.Event;

import jakarta.validation.Valid;

public interface EventService {
	
	List<Event> getAllEventsList();

//	Page<Event> getAllEvents(int page, int size, String category, String location, LocalDate date);

	Event getEventById(Long id);

//	Event createEvent(@Valid Event event, String username);
	Event createEvent(@Valid Event event, Long userId);

	Event updateEvent(Long id, EventDto eventDto);

	void deleteEvent(Long id);
	
	List<Event> getEventsForUser(Long userId);
	
	public void registerUserForEvent(Long userId, Long eventId);

	Set<Event> getRegisteredEventsByUserId(Long userId);

}

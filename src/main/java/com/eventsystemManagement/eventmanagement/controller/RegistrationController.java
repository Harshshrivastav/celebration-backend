package com.eventsystemManagement.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.eventsystemManagement.eventmanagement.model.Registration;
import com.eventsystemManagement.eventmanagement.model.User;
import com.eventsystemManagement.eventmanagement.service.RegistrationService;

@RestController
@RequestMapping("/api/events")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/{id}/register")
	public Registration registerForEvent(@PathVariable Long id, @RequestParam Long userId) {
        return registrationService.registerForEvent(id, userId);
    }
	
	@GetMapping("/{id}/attendees")
    public ResponseEntity<List<User>> getAttendeesForEvent(@PathVariable Long id) {
        try {
            List<User> attendees = registrationService.getAttendeesForEvent(id);
            return ResponseEntity.ok(attendees);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

package com.eventsystemManagement.eventmanagement.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eventsystemManagement.eventmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
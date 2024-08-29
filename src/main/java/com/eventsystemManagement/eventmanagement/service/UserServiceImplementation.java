package com.eventsystemManagement.eventmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventsystemManagement.eventmanagement.model.User;
import com.eventsystemManagement.eventmanagement.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	public UserRepository userRepository;
	
//	@Autowired 
//	public EmailService emailService;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
			if (user == null) {
	        throw new RuntimeException("User not found with username: " + username);
	    }
		return user;
	}
	
	@Override
    public boolean authenticateUser(String username, String password) {
        Optional<User> optionalUser = Optional.of(userRepository.findByUsername(username)); // Yaha pr taypecast ki dikkat aa rhi thi
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Compare raw passwords for simplicity (you should hash passwords in a real application)
            return user.getPassword().equals(password);
        }
        return false;
    }
}

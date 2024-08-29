package com.eventsystemManagement.eventmanagement.model;

public class AuthenticationResponse {
	
	private String jwt;
	private String message;
	private Long userId;
	
	public AuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthenticationResponse(String jwt, String message, Long userId) {
		super();
		this.jwt = jwt;
		this.message = message;
		this.userId = userId;
	}

	
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
	
}

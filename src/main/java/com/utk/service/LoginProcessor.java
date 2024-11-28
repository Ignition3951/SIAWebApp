package com.utk.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

	private Logger logger = Logger.getLogger(LoginProcessor.class.getName());

	private final LoggedUserManagementService loggedUserManagementService;

	public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean login() {
		logger.info("username " + this.getUsername() + " password " + this.getPassword());
		if ("utkarsh".equals(this.username) && "password".equals(this.password)) {
			loggedUserManagementService.setUsername(this.username);
			return true;
		} else {
			return false;
		}
	}
}

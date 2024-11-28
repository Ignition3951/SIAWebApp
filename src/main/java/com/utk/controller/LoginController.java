package com.utk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utk.service.LoginProcessor;

@Controller
public class LoginController {

	@Autowired
	private LoginProcessor loginProcessor;

	@GetMapping("/")
	public String loginHtml() {
		return "login.html";
	}

	@PostMapping("/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		boolean loggedIn = loginProcessor.login();
		if (loggedIn) {
			model.addAttribute("message", "You have been successfully logged in!!!!!");
		} else {
			model.addAttribute("message", "Login Failed!!!!!!!!!!");
		}
		return "login.html";
	}
}

package com.utk.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utk.service.LoggedUserManagementService;

@Controller
public class MainController {

	private final LoggedUserManagementService managementService;

	public MainController(LoggedUserManagementService managementService) {
		this.managementService = managementService;
	}

	@RequestMapping("/home")
	public String home(Model page, @RequestParam String randomName, @RequestParam String randomColor) {
		page.addAttribute("username", randomName);
		page.addAttribute("color", randomColor);
		return "home.html";
	}

	@RequestMapping("/home/{color}")
	public String homeWithPathVariable(Model page, @PathVariable String color) {
		page.addAttribute("username", "Utkarsh");
		page.addAttribute("color", color);
		return "home.html";
	}

	@GetMapping("/main")
	public String loggedInUser(@RequestParam(required = false) String logout, Model model) {
		Optional<String> username = Optional.ofNullable(managementService.getUsername());
		Optional<String> userLoggedOut = Optional.ofNullable(logout);
		if (userLoggedOut.isPresent()) {
			managementService.setUsername(null);
			return "redirect:/";
		}
		if (username.isPresent()) {
			model.addAttribute("username", username.get());
			return "main.html";
		}
		return "redirect:/";
	}

}

package com.utk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/home")
	public String home(Model page, @RequestParam String randomName, @RequestParam String randomColor) {
		page.addAttribute("username", randomName);
		page.addAttribute("color", randomColor);
		return "home.html";
	}

}

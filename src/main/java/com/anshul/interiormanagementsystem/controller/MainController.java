package com.anshul.interiormanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("isloginError", true);
		return "index";
	}
	
	@GetMapping("/loginerror")
	public String loginError(Model model) {
		model.addAttribute("isloginError", true);
		return "index";
	}
}

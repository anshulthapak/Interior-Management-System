package com.anshul.interiormanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anshul.interiormanagementsystem.entity.User;
import com.anshul.interiormanagementsystem.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/user")
	public String user(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("listuser", users);
		return "user";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user) {
		User i = new User();
		i.setName(user.getName());
		i.setUsername(user.getUsername());
		i.setPassword(passwordEncoder.encode(user.getPassword()));
		i.setMobile(user.getMobile());
		i.setDate(user.getDate());
		i.setRole(user.getRole());
		userService.saveUser(i);
		return "redirect:/user";
	}
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	@GetMapping("/user/edit/{id}")
	public String updateUser(@PathVariable String id, Model model) {
		Long ida = Long.parseLong(id);
		model.addAttribute("user", userService.getUserById(ida));
		return "editUser";
	}
	
	@PostMapping("/user/{id}")
	public String updateUser(@PathVariable String id, @ModelAttribute User user, Model model) {
		Long ida = Long.parseLong(id);
		User i = userService.getUserById(ida);
		i.setName(user.getName());
		i.setUsername(user.getUsername());
		i.setPassword(passwordEncoder.encode(user.getPassword()));
		i.setMobile(user.getMobile());
		i.setDate(user.getDate());
		i.setRole(user.getRole());
		
		userService.updateUser(i);
		
		return "redirect:/user";
		
	}
	
	@GetMapping("user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		User i = userService.getUserById(id);
		userService.deleteUser(i);
		return "redirect:/user";
	}
}

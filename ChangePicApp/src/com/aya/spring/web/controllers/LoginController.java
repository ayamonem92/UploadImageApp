package com.aya.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aya.spring.web.daos.User;
import com.aya.spring.web.services.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	@RequestMapping("/loggedout")
	public String showLogout() {
		return "loggedout";
	}
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	

	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		}
		
		user.setAuthority("user");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
			return "newaccount";
		}
		
		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
			return "newaccount";
		}
		
		
		return "accountcreated";
	}
	@RequestMapping("/updateuser")
	public String updateUser(Model model) {
		model.addAttribute("user", new User());
		return "updateuser";
	}
	@RequestMapping(value="/updateaccount", method=RequestMethod.POST)
	public String updateAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "updateuser";
		}
		user.setAuthority("user");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
			return "updateuser";
		}
		
		try {
			usersService.update(user);
			System.out.println(user.getEmail());
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username", "This username already exists!");
			return "updateuser";
		}
		
		
		return "accountupdated";
	}
	@RequestMapping("/admin")
	public String Admin(Model model){
	
		//Now lets send data from controller to jsp home file by using model object
		List<User> users = usersService.getAllUsers();
		model.addAttribute("users",users);
		return "admin";
	}
}
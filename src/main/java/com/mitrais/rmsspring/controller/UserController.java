package com.mitrais.rmsspring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.service.UserService;

@Controller
@SessionAttributes("loggedinUser")
public class UserController {
	
	@Autowired UserService service;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		model.put("users", service.retrieveAllUser());
		return "users/list";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.GET)
	public String showAddUserForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "users/user";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String addUser(ModelMap model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "users/user";
		}
		service.addUser(user);
		return "redirect:/list";
	}
	
	@RequestMapping(value="update-user", method=RequestMethod.GET)
	public String showUpdateUserForm(ModelMap model, @RequestParam Long id) {
		model.addAttribute("user", service.findUser(id));
		return "users/user";
	}
	
	@RequestMapping(value="update-user", method=RequestMethod.POST)
	public String updateUser(ModelMap model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "users/user";
		}
		service.updateUser(user);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam Long id) {
		service.deleteUser(id);
		return "redirect:/list";
	}
}

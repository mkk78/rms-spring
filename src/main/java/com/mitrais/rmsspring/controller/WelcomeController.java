package com.mitrais.rmsspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mitrais.rmsspring.model.User;
import com.mitrais.rmsspring.security.MyUserPrincipal;

@Controller
@SessionAttributes("loggedinUser")
public class WelcomeController {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("loggedinUser", getLoggedinUser());
		return "welcome";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		return "redirect:/";
	}
	
	private User getLoggedinUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof MyUserPrincipal) {
			return ((MyUserPrincipal) principal).getUser();
		}
		
		System.out.println("TEST");
		return null;
		
	}
	
}

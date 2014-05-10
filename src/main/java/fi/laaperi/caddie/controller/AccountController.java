package fi.laaperi.caddie.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Role;
import fi.laaperi.caddie.domain.User;
import fi.laaperi.caddie.service.BCryptPasswordEncoder;
import fi.laaperi.caddie.service.UserService;

@Controller 
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		logger.info("user-login");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		logger.info("error-login");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerForm() {
		logger.info("register");
		
		User newUser = new User();
		newUser.setLogin("new User");
		
		return new ModelAndView("register", "user", newUser);
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(Principal principal,
									@RequestParam("login")String login, 
									@RequestParam("password")String password) {
		
		logger.info("Register user: " + login + ", " + password);
		
		User newUser = new User();
		newUser.setLogin(login);
		newUser.setPassword(new BCryptPasswordEncoder().encode(password));
		
		
		userService.registerUser(newUser, Role.ROLE_USER);
		return new ModelAndView("home");
	}
	
}

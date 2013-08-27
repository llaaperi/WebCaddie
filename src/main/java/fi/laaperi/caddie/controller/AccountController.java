package fi.laaperi.caddie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.User;

@Controller 
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
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
	
	@RequestMapping(value="/user-register", method=RequestMethod.GET)
	public ModelAndView registerForm() {
		logger.info("user-register");
		
		User newUser = new User();
		newUser.setLogin("new User");
		
		return new ModelAndView("register", "user", newUser);
	}
	
	@RequestMapping(value="/user-save", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user")User user, ModelMap model) {
		
		logger.info("Creating user " + user.getLogin());
		
		return new ModelAndView("home");
	}
	
}

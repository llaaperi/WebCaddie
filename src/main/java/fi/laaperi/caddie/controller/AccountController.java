package fi.laaperi.caddie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping(value="/user-register", method=RequestMethod.GET)
	public ModelAndView registerForm() {
		logger.info("user-register");
		return new ModelAndView("login");
	}
	
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
	
}

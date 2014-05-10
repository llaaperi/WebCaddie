package fi.laaperi.caddie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		logger.info("login");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login-error", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		logger.info("login-error");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
}

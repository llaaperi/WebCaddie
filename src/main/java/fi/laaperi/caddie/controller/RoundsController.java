package fi.laaperi.caddie.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Hole;
import fi.laaperi.caddie.domain.Round;
import fi.laaperi.caddie.repository.RoundDao;
import fi.laaperi.caddie.repository.RoundDaoImpl;
import fi.laaperi.caddie.service.RoundManager;

@Controller
public class RoundsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);
	private RoundManager roundManager = new RoundManager();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.GET)
	public ModelAndView rounds(Locale locale, Model model) {
		logger.info("List rounds");
		List<Round> rounds = roundManager.getRounds();
	    ModelAndView mv = new ModelAndView("rounds");
	    mv.addObject("rounds", rounds);
	    return mv;
	}
	
	@RequestMapping(value = "/viewRound", method = RequestMethod.GET)
	public ModelAndView openRound(@RequestParam("id")long id) {
		logger.info("View round " + id);
		Round round = roundManager.getRound(id);
		return new ModelAndView("round", "round", round);
	}
	
	@RequestMapping(value = "/newRound", method = RequestMethod.GET)
	public ModelAndView round() {
		logger.info("New round");
		Round newRound = roundManager.createNew();
		return new ModelAndView("round", "round", newRound);
	}
	
	@RequestMapping(value = "/saveRound", method = RequestMethod.POST)
	public String saveRound(@ModelAttribute("rounds")Round round, ModelMap model) {
		logger.info("Save round");
		roundManager.saveRound(round);
		return "redirect:rounds";
	}
}

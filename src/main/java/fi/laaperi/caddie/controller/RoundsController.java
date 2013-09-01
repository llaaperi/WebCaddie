package fi.laaperi.caddie.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;
import fi.laaperi.caddie.service.CourseService;
import fi.laaperi.caddie.service.RoundService;

@Controller
public class RoundsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);
	//private RoundManager roundManager = new RoundManager();
	
	@Autowired
	RoundService roundService;
	
	//TODO this to round service
	@Autowired
	CourseService courseService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.GET)
	public ModelAndView rounds(Locale locale, Model model) {
		logger.info("List rounds");
		List<Round> rounds = roundService.getRounds();
	    ModelAndView mv = new ModelAndView("rounds");
	    mv.addObject("rounds", rounds);
	    
		mv.addObject("courses", courseService.getCourses());
	    return mv;
	}
	
	@RequestMapping(value = "/rounds/viewRound", method = RequestMethod.GET)
	public ModelAndView openRound(@RequestParam("id")long id) {
		logger.info("View round " + id);
		Round round = roundService.getRound(id);
		return new ModelAndView("round", "round", round);
	}
	
	@RequestMapping(value = "/rounds/newRound", method = RequestMethod.GET)
	public ModelAndView round(@RequestParam("courseId")long id) {
		logger.info("New round");
		
		ModelAndView mv = new ModelAndView("round");
		
		Course course = courseService.getCourse(id);
		Round newRound = roundService.createNew(course);
		mv.addObject("round", newRound);
		
		return mv;
	}
	
	@RequestMapping(value = "/rounds/saveRound", method = RequestMethod.POST)
	public String saveRound(@ModelAttribute("rounds")Round round, ModelMap model) {
		logger.info("Save round at ");
		
		Course course = courseService.getCourse(round.getCourseId());
		round.setCourse(course);
		roundService.saveRound(round);
		
		return "redirect:/rounds";
	}
	
	@RequestMapping(value = "/rounds/deleteRound", method = RequestMethod.GET)
	public String deleteCourse(@RequestParam("id")long id, Model model) {
		logger.info("Delete round " + id);
		roundService.deleteRound(id);
		return "redirect:/rounds";
	}
}

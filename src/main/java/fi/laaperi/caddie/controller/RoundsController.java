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
import fi.laaperi.caddie.repository.CourseDao;
import fi.laaperi.caddie.repository.CourseDaoImpl;
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
	    CourseDao courseDao = new CourseDaoImpl();
		mv.addObject("courses", courseDao.list());
	    return mv;
	}
	
	@RequestMapping(value = "/rounds/viewRound", method = RequestMethod.GET)
	public ModelAndView openRound(@RequestParam("id")long id) {
		logger.info("View round " + id);
		Round round = roundManager.getRound(id);
		return new ModelAndView("round", "round", round);
	}
	
	@RequestMapping(value = "/rounds/newRound", method = RequestMethod.GET)
	public ModelAndView round(@RequestParam("courseId")long id) {
		logger.info("New round");
		
		ModelAndView mv = new ModelAndView("round");
		
		CourseDao courseDao = new CourseDaoImpl();
		Course course = courseDao.findById(id);
		
		Round newRound = roundManager.createNew(course);
		mv.addObject("round", newRound);
		
		return mv;
	}
	
	@RequestMapping(value = "/rounds/saveRound", method = RequestMethod.POST)
	public String saveRound(@ModelAttribute("rounds")Round round, ModelMap model) {
		logger.info("Save round at ");
		CourseDao courseDao = new CourseDaoImpl();
		Course course = courseDao.findById(round.getCourseId());
		round.setCourse(course);
		roundManager.saveRound(round);
		return "redirect:/rounds";
	}
	
	@RequestMapping(value = "/rounds/deleteRound", method = RequestMethod.GET)
	public String deleteCourse(@RequestParam("id")long id, Model model) {
		logger.info("Delete round " + id);
		roundManager.deleteRound(id);
		return "redirect:/rounds";
	}
}

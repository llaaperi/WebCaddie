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
import fi.laaperi.caddie.repository.CourseDao;
import fi.laaperi.caddie.repository.CourseDaoImpl;

@Controller
public class CoursesController {

	private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);
	private CourseDao courseDao = new CourseDaoImpl();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView courses(Locale locale, Model model) {
		logger.info("List courses");
		List<Course> courses = courseDao.list();
		
	    ModelAndView mv = new ModelAndView("courses");
	    mv.addObject("courses", courses);
	    return mv;
	}
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public String deleteCourse(@RequestParam("id")long id, Model model) {
		logger.info("Delete course " + id);
		//Course course = courseDao.findById(id);
		//courseDao.delete(course);
		courseDao.delete(id);
		return "redirect:courses";
	}
	
	@RequestMapping(value = "/viewCourse", method = RequestMethod.GET)
	public ModelAndView openCourse(@RequestParam("id")long id, Model model) {
		logger.info("View course" + id);
		Course course = courseDao.findById(id);
		return new ModelAndView("course", "command", course);
	}
	
	@RequestMapping(value = "/newCourse", method = RequestMethod.GET)
	public ModelAndView course(Locale locale, Model model) {
		logger.info("New course");
		return new ModelAndView("course", "command", new Course());
	}
	
	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("courses")Course course, ModelMap model) {
		logger.info("Save course");
		courseDao.persist(course);
		return "redirect:courses";
	}
	
}

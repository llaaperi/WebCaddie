package fi.laaperi.caddie;

import java.text.DateFormat;
import java.util.Date;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView courses(Locale locale, Model model) {
		
		CourseDao dao = new CourseDaoImpl();
		List<Course> courses = dao.list();
		
	    ModelAndView mv = new ModelAndView("courses");
	    mv.addObject("courses", courses);
	    return mv;
		//return "courses";
	}
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public String deleteCourse(@RequestParam("id")long id, Model model) {
		logger.info("Deleting course " + id);

		CourseDao dao = new CourseDaoImpl();
		Course course = dao.findById(id);
		logger.info("Deleting course " + course.getName());
		
		dao.delete(course);
		
		return "redirect:courses";
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("courses")Course course, ModelMap model) {
		logger.info("Adding course " + course.getName());
		
		model.addAttribute("name", course.getName());
		model.addAttribute("par", course.getPar());
		model.addAttribute("slope", course.getSlope());

		CourseDao dao = new CourseDaoImpl();
		dao.save(course);
		
		return "redirect:courses";
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView course(Locale locale, Model model) {
		
		return new ModelAndView("course", "command", new Course());
		//return "courses";
	}
	
	@RequestMapping(value = "/openCourse", method = RequestMethod.GET)
	public ModelAndView openCourse(@RequestParam("id")long id, Model model) {
		
		CourseDao dao = new CourseDaoImpl();
		Course course = dao.findById(id);
		
		return new ModelAndView("course", "command", course);
		//return "courses";
	}
	
}

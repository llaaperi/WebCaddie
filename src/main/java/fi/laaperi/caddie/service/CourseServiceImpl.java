package fi.laaperi.caddie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.repository.CourseDao;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public Course createNew(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course getCourse(long id) {
		return courseDao.findById(id);
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.list();
	}

	@Override
	public void saveCourse(Course course) {
		courseDao.save(course);
	}

	@Override
	public void deleteCourse(long id) {
		courseDao.delete(id);
	}
	
	
}

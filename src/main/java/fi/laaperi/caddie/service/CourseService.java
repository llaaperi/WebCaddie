package fi.laaperi.caddie.service;

import java.util.List;

import fi.laaperi.caddie.domain.Course;

public interface CourseService {

	public abstract Course createNew(Course course);

	public abstract Course getCourse(long id);

	public abstract List<Course> getCourses();

	public abstract void saveCourse(Course course);
	
	public abstract void deleteCourse(long id);

}
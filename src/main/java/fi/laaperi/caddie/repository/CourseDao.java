package fi.laaperi.caddie.repository;

import java.util.List;

import fi.laaperi.caddie.domain.Course;

public interface CourseDao {

	public long save(Course course);
	
	public void delete(Course course);
	
	public List<Course> list();
	
	public Course findById(long id);
	
}

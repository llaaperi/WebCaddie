package fi.laaperi.caddie.repository;

import java.util.List;

import fi.laaperi.caddie.domain.Course;

public interface CourseDao {

	public void persist(Course course);
	
	
	public long save(Course course);
	
	public long update(Course course);
	
	public void delete(Course course);
	
	public List<Course> list();
	
	public Course findById(long id);
	
}

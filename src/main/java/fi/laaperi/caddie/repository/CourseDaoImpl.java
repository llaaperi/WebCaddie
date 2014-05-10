package fi.laaperi.caddie.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.Course;

@Repository("courseDao")
@Scope(value="singleton")
public class CourseDaoImpl implements CourseDao {

	private static final Logger logger = LoggerFactory.getLogger(CourseDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void persist(Course course) {
		
	}
	
	@Override
	public long save(Course course) {
		logger.info("Saving course " + course.getName() + ", id " + course.getId());
		return 0;
		
	}
	
	@Override
	public long update(Course course) {
		logger.info("Updating course " + course.getName() + ", id " + course.getId());
		return 0;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> list() {
		return null;
	}

	@Override
	public void delete(Course course) {

	}
	
	@Override
	public void delete(long id) {
		
	}
	
	@Override
	public Course findById(long id){
		return null;
	}
	
}

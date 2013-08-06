package fi.laaperi.caddie.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.HomeController;
import fi.laaperi.caddie.domain.Course;

@Repository
@Scope(value="singleton")
public class CourseDaoImpl implements CourseDao {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private SessionFactory sessionFactory;
	
	public CourseDaoImpl(){
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                .getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		logger.info("CourseDao created");
	}
	
	@Override
	public long save(Course course) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		logger.info("Course " + course.getName() + " saved");
		return course.getId();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> list() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Course> courses = session.createCriteria(Course.class).list();
		session.getTransaction().commit();
		return courses;
	}

	@Override
	public void delete(Course course) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
	}
	
	@Override
	public Course findById(long id){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Course course = (Course)session.get(Course.class, id);
		session.getTransaction().commit();
		return course;
	}
	
}

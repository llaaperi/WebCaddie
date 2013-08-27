package fi.laaperi.caddie.repository;

import java.util.ArrayList;
import java.util.List;







import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;
import fi.laaperi.caddie.domain.User;
import fi.laaperi.caddie.service.CustomUserDetailsService;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	//@Autowired 
	private SessionFactory sessionFactory;  

	public UserDaoImpl(){
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                .getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		logger.info("UserDao created");
	}
	
	private Session openSession() {  
		return sessionFactory.getCurrentSession();  
	}  

	@SuppressWarnings("unchecked")
	public User getUser(String login) {  
		logger.info("Get user " + login);
		
		List<User> userList = new ArrayList<User>();  
		Session session = openSession();
		session.beginTransaction();
		
		try{
			String hql = "FROM User U WHERE U.login = :login";
			userList = session.createQuery(hql).setParameter("login", login).list();
		}catch(HibernateException e){
			logger.info(e.getMessage());
		}
		
		session.getTransaction().commit();
		
		if (userList.size() > 0){
			logger.info("User " + login + " found");
			return userList.get(0);  
		}else{
			logger.info("No user " + login + " found");
			return null;
		}
	}
	
}

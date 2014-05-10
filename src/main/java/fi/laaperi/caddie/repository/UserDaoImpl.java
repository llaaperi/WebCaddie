package fi.laaperi.caddie.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.User;

@Repository("userDao")
@Scope(value="singleton")
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired 
	SessionFactory sessionFactory;  
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private long save(User user) {
		Session session = getCurrentSession();
		session.save(user);
		return user.getId();
	}
	
	private long update(User user) {
		Session session = getCurrentSession();
		session.update(user);
		return user.getId();
	}
	
	private long merge(User user) {
		Session session = getCurrentSession();
		session.merge(user);
		return user.getId();
	}
	
	@Override
	public long persist(User user) {

		User existing = getUser(user.getLogin());
		if(existing != null){
			return merge(user);
		}else{
			return save(user);
		}
	}
	
	@Override
	public void delete(User user) {
		Session session = getCurrentSession();
		session.delete(user);
	}
	
	@Override
	public User getUser(String login) { 
		List<User> userList = new ArrayList<User>();  
		Session session = getCurrentSession();
		
		try{
			String hql = "FROM User U WHERE U.login = :login";
			userList = session.createQuery(hql).setParameter("login", login).list();
		}catch(HibernateException e){
			logger.info(e.getMessage());
		}
		
		if (userList.size() > 0){
			//logger.info("User " + login + " found");
			return userList.get(0);  
		}else{
			//logger.info("No user " + login + " found");
			return null;
		}
	}
	
}

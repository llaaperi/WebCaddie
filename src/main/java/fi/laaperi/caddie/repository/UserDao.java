package fi.laaperi.caddie.repository;

import fi.laaperi.caddie.domain.User;

public interface UserDao {
	
	
	public long persist(User user);
	
	public void delete(User user);
	
	public User getUser(String login);
	
}
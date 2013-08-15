package fi.laaperi.caddie.repository;

import fi.laaperi.caddie.domain.User;

public interface UserDao {
	
	public User getUser(String login);
	
}
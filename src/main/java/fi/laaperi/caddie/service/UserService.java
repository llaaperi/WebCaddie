package fi.laaperi.caddie.service;

import fi.laaperi.caddie.domain.User;

public interface UserService {

	public User getUser(String login);
	
	public void saveUser(User user);
	
}
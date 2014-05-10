package fi.laaperi.caddie.service;

import fi.laaperi.caddie.domain.User;

public interface UserService {
	
	public boolean registerUser(User user, String role);
	
	public User getUser(String login);
	
	public void saveUser(User user);
	
}
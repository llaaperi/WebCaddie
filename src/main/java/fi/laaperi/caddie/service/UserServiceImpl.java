package fi.laaperi.caddie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.domain.User;
import fi.laaperi.caddie.repository.UserDao;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	//@Autowired  
    private UserDao userDAO;  
  
    /* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.UserService#getUser(java.lang.String)
	 */
    @Override
	public User getUser(String login) {  
        return userDAO.getUser(login);  
    }
	
}

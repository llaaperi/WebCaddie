package fi.laaperi.caddie.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.controller.AccountController;
import fi.laaperi.caddie.domain.User;
import fi.laaperi.caddie.repository.UserDao;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired  
    private UserDao userDao;  
  
    /* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.UserService#getUser(java.lang.String)
	 */
    @Override
	public User getUser(String login) {  
        return userDao.getUser(login);  
    }

	@Override
	public void saveUser(User user) {
		logger.info("Saving user " + user.getLogin());
	}
    
}

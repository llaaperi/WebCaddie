package fi.laaperi.caddie.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.controller.AccountController;
import fi.laaperi.caddie.domain.Role;
import fi.laaperi.caddie.domain.User;
import fi.laaperi.caddie.repository.RoleDao;
import fi.laaperi.caddie.repository.UserDao;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired  
    UserDao userDao;  
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public boolean registerUser(User user, String role){
		//Check input attribute
		if(user == null){logger.info("registerUser null argument");return false;}
		
		User existingUser = userDao.getUser(user.getLogin());
		if(existingUser != null){
			logger.info("User <" + user.getLogin() +"> already exists");
			return false;
		}
		logger.info("Registering user <" + user.getLogin() +">");
		
		Role r;
		if(role.equals(Role.ROLE_ADMIN)){
			r = roleDao.getRole(1);
		}else{
			r = roleDao.getRole(2);
		}
		user.setRole(r);
		userDao.persist(user);
		
		return true;
	}
	
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

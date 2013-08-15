package fi.laaperi.caddie.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.controller.HomeController;
import fi.laaperi.caddie.repository.UserDao;
import fi.laaperi.caddie.repository.UserDaoImpl;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	//@Autowired  
    private UserDao userDAO = new UserDaoImpl();
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		logger.info("Load user " + login);
		
		fi.laaperi.caddie.domain.User domainUser = userDAO.getUser(login);  
        
		logger.info("Loaded user " + domainUser.getLogin());
		
        boolean enabled = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        
        return new User(  
                domainUser.getLogin(),   
                domainUser.getPassword(),   
                enabled,   
                accountNonExpired,   
                credentialsNonExpired,
                accountNonLocked,
                getGrantedAuthorities(getRoles(1))
                //getAuthorities(domainUser.getRole().getId())  
        ); 
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {  
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));  
        return authList;  
    }  
      
    public List<String> getRoles(Integer role) {  
  
        List<String> roles = new ArrayList<String>();  
  
        if (role.intValue() == 1) {  
            roles.add("ROLE_MODERATOR");  
            roles.add("ROLE_ADMIN");  
        } else if (role.intValue() == 2) {  
            roles.add("ROLE_MODERATOR");  
        }  
        return roles;  
    }  
      
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {  
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
          
        for (String role : roles) {  
            authorities.add(new SimpleGrantedAuthority(role));  
        }  
        return authorities;  
    }
    
}
package fi.laaperi.caddie.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	//@Autowired 
	private SessionFactory sessionFactory;  

	private Session getCurrentSession() {  
		return sessionFactory.getCurrentSession();  
	}  

	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.repository.RoleDao#getRole(int)
	 */
	@Override
	public Role getRole(int id) {  
		Role role = (Role) getCurrentSession().load(Role.class, id);  
		return role;  
	}
	
}

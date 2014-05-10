package fi.laaperi.caddie.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.Role;

@Repository("roleDao")
@Scope(value="singleton")
public class RoleDaoImpl implements RoleDao {
	
	@Autowired 
	SessionFactory sessionFactory;  

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

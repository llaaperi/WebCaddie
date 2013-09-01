package fi.laaperi.caddie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.domain.Role;
import fi.laaperi.caddie.repository.RoleDao;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
    private RoleDao roleDAO;
	
    /* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoleService#getRole(int)
	 */
    @Override
	public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
	
}

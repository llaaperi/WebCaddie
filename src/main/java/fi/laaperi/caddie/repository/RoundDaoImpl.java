package fi.laaperi.caddie.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.domain.Round;

@Repository("roundDao")
@Scope(value="singleton")
public class RoundDaoImpl implements RoundDao {

	private static final Logger logger = LoggerFactory.getLogger(RoundDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void persist(Round round) {
		logger.info("Round " + round.getDateString() + " persisted");
	}

	@Override
	public long save(Round round) {
		logger.info("Saving round id " + round.getId());
		return 0;
	}

	@Override
	public long update(Round round) {
		logger.info("Updating course " + round.getDateString() + ", id " + round.getId());
		return 0;
	}

	@Override
	public void delete(Round round) {
		
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Round> list() {
		return null;
	}

	@Override
	public Round findById(long id) {
		return null;
	}

}

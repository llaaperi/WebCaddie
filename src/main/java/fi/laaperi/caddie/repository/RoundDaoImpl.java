package fi.laaperi.caddie.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import fi.laaperi.caddie.controller.HomeController;
import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;

@Repository("roundDao")
@Scope(value="singleton")
public class RoundDaoImpl implements RoundDao {

	private static final Logger logger = LoggerFactory.getLogger(RoundDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public RoundDaoImpl(){
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                .getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
		logger.info("RoundDao created");
	}
	
	@Override
	public void persist(Round round) {
		Round existing = findById(round.getId());
		if(existing != null){
			update(round);
		}else{
			save(round);
		}
		logger.info("Round " + round.getDateString() + " persisted");
	}

	@Override
	public long save(Round round) {
		logger.info("Saving round id " + round.getId());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(round);
		session.flush();
		session.getTransaction().commit();
		logger.info("Course " + round.getId()+ " saved");
		return round.getId();
	}

	@Override
	public long update(Round round) {
		logger.info("Updating course " + round.getDateString() + ", id " + round.getId());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(round);
		session.flush();
		session.getTransaction().commit();
		logger.info("Course " + round.getDateString() + " updated");
		return round.getId();
	}

	@Override
	public void delete(Round round) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(round);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Round round = (Round)session.get(Round.class, id);
		session.delete(round);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Round> list() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Round> rounds = session.createCriteria(Round.class).list();
		session.flush();
		session.getTransaction().commit();
		return rounds;
	}

	@Override
	public Round findById(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Round round = (Round)session.get(Round.class, id);
		session.flush();
		session.getTransaction().commit();
		return round;
	}

}

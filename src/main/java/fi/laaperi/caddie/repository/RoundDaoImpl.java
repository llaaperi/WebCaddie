package fi.laaperi.caddie.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.laaperi.caddie.controller.HomeController;
import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;

public class RoundDaoImpl implements RoundDao {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Round round) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

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

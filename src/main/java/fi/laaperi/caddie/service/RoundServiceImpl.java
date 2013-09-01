package fi.laaperi.caddie.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.laaperi.caddie.controller.AccountController;
import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;
import fi.laaperi.caddie.repository.RoundDao;

@Service("roundService")
@Transactional
public class RoundServiceImpl implements RoundService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoundServiceImpl.class);
	
	@Autowired
	private RoundDao roundDao;
	
	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoundService#createNew(fi.laaperi.caddie.domain.Course)
	 */
	@Override
	public Round createNew(Course course){
		Round round = new Round(course);
		return round;
	}
	
	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoundService#getRound(long)
	 */
	@Override
	public Round getRound(long id){
		return roundDao.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoundService#getRounds()
	 */
	@Override
	public List<Round> getRounds(){
		return roundDao.list();
	}
	
	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoundService#saveRound(fi.laaperi.caddie.domain.Round)
	 */
	@Override
	public void saveRound(Round round){
		roundDao.persist(round);
	}
	
	/* (non-Javadoc)
	 * @see fi.laaperi.caddie.service.RoundService#deleteRound(long)
	 */
	@Override
	public void deleteRound(long id){
		roundDao.delete(id);
	}
	
}

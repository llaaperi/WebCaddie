package fi.laaperi.caddie.service;

import java.util.List;

import fi.laaperi.caddie.domain.Round;
import fi.laaperi.caddie.repository.RoundDao;
import fi.laaperi.caddie.repository.RoundDaoImpl;

public class RoundManager {

	private RoundDao roundDao;
	
	public RoundManager(){
		roundDao = new RoundDaoImpl();
	}
	
	public Round createNew(){
		Round round = new Round();
		return round;
	}
	
	public Round getRound(long id){
		return roundDao.findById(id);
	}
	
	public List<Round> getRounds(){
		return roundDao.list();
	}
	
	public void saveRound(Round round){
		roundDao.save(round);
	}
	
}

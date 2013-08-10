package fi.laaperi.caddie.repository;

import java.util.List;

import fi.laaperi.caddie.domain.Round;

public interface RoundDao {

	public void persist(Round round);
	
	
	public long save(Round round);
	
	public long update(Round round);
	
	public void delete(Round round);
	public void delete(long id);
	
	public List<Round> list();
	
	public Round findById(long id);
	
}
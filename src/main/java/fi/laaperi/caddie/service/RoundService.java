package fi.laaperi.caddie.service;

import java.util.List;

import fi.laaperi.caddie.domain.Course;
import fi.laaperi.caddie.domain.Round;

public interface RoundService {

	public abstract Round createNew(Course course);

	public abstract Round getRound(long id);

	public abstract List<Round> getRounds();

	public abstract void saveRound(Round round);

	public abstract void deleteRound(long id);

}
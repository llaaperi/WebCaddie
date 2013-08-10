package fi.laaperi.caddie.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Round")
public class Round {
	
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
	@GeneratedValue(generator = "hilo-strategy")
	long id;

	Date date;
	
	@OneToOne
	Course course;
	
	int[] strokes;
	
	public Round(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int[] getStrokes() {
		return strokes;
	}

	public void setStrokes(int[] strokes) {
		this.strokes = strokes;
	}
	
	public String getDateString(){
		return "TODO:Date";
	}
	
}

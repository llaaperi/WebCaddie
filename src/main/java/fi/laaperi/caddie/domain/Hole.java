package fi.laaperi.caddie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Hole")
public class Hole {
	
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
	@GeneratedValue(generator = "hilo-strategy")
	private long id;
	
	@ManyToOne
	Course course;
	
	private int par;
	private int hcp;
	private int lenWhite;
	private int lenYellow;
	private int lenRed;
	
	public Hole(){}
	
	public Hole(Course course){
		this.course = course;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getHcp() {
		return hcp;
	}

	public void setHcp(int hcp) {
		this.hcp = hcp;
	}

	public int getLenWhite() {
		return lenWhite;
	}

	public void setLenWhite(int lenWhite) {
		this.lenWhite = lenWhite;
	}

	public int getLenYellow() {
		return lenYellow;
	}

	public void setLenYellow(int lenYellow) {
		this.lenYellow = lenYellow;
	}

	public int getLenRed() {
		return lenRed;
	}

	public void setLenRed(int lenRed) {
		this.lenRed = lenRed;
	}
	
}

package fi.laaperi.caddie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
	@GeneratedValue(generator = "hilo-strategy")
	long id;
	
	String name;
	int par;
	int slope;
	
	public Course(){}
	
	public Course(String name){
		this.name = name;
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}
	
}

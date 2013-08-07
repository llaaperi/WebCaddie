package fi.laaperi.caddie.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Course {
	
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
	@GeneratedValue(generator = "hilo-strategy")
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="course")
	private List<Hole> holes = new ArrayList<Hole>();
	
	private String name;
	private int par;
	private int slope;
	
	public Course(){
		for(int i = 0; i < 18; i++){
			Hole hole = new Hole();
			this.addHole(hole);
		}
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
	
	public List<Hole> getHoles(){
		return this.holes;
	}
	
	public void addHoles(){
		for(int i = 0; i < 18; i++){
			Hole hole = new Hole();
			this.addHole(hole);
		}
	}
	
	public void addHole(Hole hole) {
		hole.setCourse(this);
		this.holes.add(hole);
	}
	
}

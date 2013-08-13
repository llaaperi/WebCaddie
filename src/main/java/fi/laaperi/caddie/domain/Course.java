package fi.laaperi.caddie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
	@GeneratedValue(generator = "hilo-strategy")
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@IndexColumn(name="idx")
	@JoinColumn(name="course_id")
	List<Hole> holes = new ArrayList<Hole>();
	
	private String name;
	private int slope;
	
	public Course(){
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

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}
	
	public List<Hole> getHoles(){
		return this.holes;
		//return new ArrayList<Hole>();
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
	
	public int getLengthWhite(){
		int sum = 0;
		for(Hole hole : holes){
			sum += hole.getLenWhite();
		}
		return sum;
	}
	
	public int getLengthWhite9(){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += holes.get(i).getLenWhite();
		}
		return sum;
	}
	
	public int getLengthWhite18(){
		int sum = 0;
		for(int i = 9; i < 18; i++){
			sum += holes.get(i).getLenWhite();
		}
		return sum;
	}
	
	public int getLengthYellow(){
		int sum = 0;
		for(Hole hole : holes){
			sum += hole.getLenYellow();
		}
		return sum;
	}
	
	public int getLengthYellow9(){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += holes.get(i).getLenYellow();
		}
		return sum;
	}
	
	public int getLengthYellow18(){
		int sum = 0;
		for(int i = 9; i < 18; i++){
			sum += holes.get(i).getLenYellow();
		}
		return sum;
	}
	
	public int getLengthRed(){
		int sum = 0;
		for(Hole hole : holes){
			sum += hole.getLenRed();
		}
		return sum;
	}
	
	
	public int getLengthRed9(){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += holes.get(i).getLenRed();
		}
		return sum;
	}
	
	public int getLengthRed18(){
		int sum = 0;
		for(int i = 9; i < 18; i++){
			sum += holes.get(i).getLenRed();
		}
		return sum;
	}
	
	public int getPar(){
		int sum = 0;
		for(Hole hole : holes){
			sum += hole.getPar();
		}
		return sum;
	}
	
	public int getPar9(){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += holes.get(i).getPar();
		}
		return sum;
	}
	
	public int getPar18(){
		int sum = 0;
		for(int i = 9; i < 18; i++){
			sum += holes.get(i).getPar();
		}
		return sum;
	}
}

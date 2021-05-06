import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentGrade {
	String name;
    HashMap<String, Integer> marks = new HashMap<String, Integer>();
	
    //CONSTRUCTOR
	public StudentGrade(String name) {
		this.name=name;
	}
	
	//RETURNS NAME OF STUDENT
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	} 
	
	//ADDS SCORE TO THE SPECIFIED CRITERION
	public void addMark(String criterion, int score) {
		if(score<6 && score >0) {
		marks.put(criterion,score);
		}else {
			throw new IllegalArgumentException("Score must be between 1 and 5");
		}
	}

	//RETURNS SCORE OF CRITERION SPECIFIED CRITERION
	public int getScore(String criterion) {
		return marks.get(criterion);
	}
	
	//RETURNS HASHMAP OF CRITERIONS AND SCORES ON GRADE
	public HashMap<String, Integer> getMarks(){
		return marks;
	}
	
	
}

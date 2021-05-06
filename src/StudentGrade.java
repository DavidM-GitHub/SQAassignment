import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentGrade {
	String name;
    HashMap<String, Integer> marks = new HashMap<String, Integer>();
	
	public StudentGrade(String name) {
		this.name=name;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	} 
	
	public void addMark(String criterion, int score) {
		if(score<6 && score >0) {
		marks.put(criterion,score);
		}else {
			throw new IllegalArgumentException("Score must be between 1 and 5");
		}
	}

	public int getScore(String criterion) {
		return marks.get(criterion);
	}
	
	public HashMap<String, Integer> getMarks(){
		return marks;
	}
	
	
}

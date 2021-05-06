import java.util.ArrayList;
import java.util.List;

public class Rubric {
	List<String> criteria=new ArrayList<String>();
	List<StudentGrade> grades=new ArrayList<StudentGrade>();
	String name;
	
	//CONSTRUCTOR
	public Rubric(String name) {
		this.name=name;
	}

	//ADDS CRITERION TO RUBRIC
	public void addCriterion(String criterion) {
		if(criteria.size()<10) {
		criteria.add(criterion);
		}else {
			System.out.println("Rubric full");
		}
	}
	
	//ADDS STUDENT GRADE TO RUBRIC
	public void addStudentGrade(StudentGrade grade) {
		grades.add(grade);
	}
	
	//RETURNS LIST OF STUDENT GRADES IN RUBRIC
	public List<StudentGrade> getGrades(){
		return grades;
	}
	
	//RETURNS NAME OF RUBRIC
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	//RETURNS LIST OF CRITERIA IN RUBRIC
	public List<String> getCriteria() {
		// TODO Auto-generated method stub
		return criteria;
	}
}

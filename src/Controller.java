import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
	List<Rubric> rubrics=new ArrayList<Rubric>();
	
	public Controller() {
		
	}

	//ADDS CRITERION TO RUBRIC
	public void addCriterionToRubric(Rubric rubric, String designCriterion) {
		rubric.addCriterion(designCriterion);
	}

	//CREATES RUBRIC AND ADDS IT TO LIST OF RUBRICS
	public Rubric createRubric(String name) {
		Rubric rubric=new Rubric(name);
		rubrics.add(rubric);
		return rubric;
	}	
	
	//RETURNS LIST OF ALL RUBRICS
	public List<Rubric> getAllRubrics() {
		return rubrics;
	}

	//SEARCHES RUBRIC BY NAME 
	public Rubric getRubricByName(String name) {
		Rubric rubricFound=null;
		for(Rubric rubric:rubrics) {
			if(rubric.getName().equalsIgnoreCase(name)) {
				rubricFound=rubric;
			}
		}
		if(rubricFound==null) {
			throw new NullPointerException();
		}
		return rubricFound;
	}
	
	//CREATES STUDENT GRADE ADDING SCORE TO EACH CRITERION IN A RUBRIC
	public StudentGrade createStudentGrade(Rubric rubric, String name, int score) {
		StudentGrade grade=new StudentGrade(name);
		//for criterion in rubric
		List<String> criteria=rubric.getCriteria();
		for(String criterion:criteria) {
			//add mark to grade
			grade.addMark(criterion,score);
		}		
		//add grade to rubric
		rubric.addStudentGrade(grade);
		
		return grade;
	}
	
	//CALCULATES AVERAGE OF ALL SCORES IN RUBRIC
	public double getAverageForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		double sum=0;
		double count=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			count+=marks.size();
			for(int i:marks.values()) {
				System.out.println("score: "+i);
				sum+=i;
			}
		}
		return sum/count;
	}
	
	//CALCULATES MAXIMIUM OF ALL SCORES IN RUBRIC
	public int getMaxForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		int max=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			for(int i:marks.values()) {
				if(i>max) {
					max=i;
				}
			}
		}
		return max;
	}
	
	//CALCULATES MINIMUM OF ALL SCORES IN RUBRIC
	public int getMinForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		int min=6;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			for(int i:marks.values()) {
				if(i<min) {
					min=i;
				}
			}
		}
		return min;
	}
	
	//CALCULATES STANDARD DEVIATION OF ALL SCORES IN RUBRIC
	public double getStandardDeviationForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		double mean=getAverageForRubric(rubric);
		double stdDeviation=0;
		int count=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			count+=marks.size();
			for(int i:marks.values()) {
				stdDeviation+= Math.pow((i-mean),2);
			}
		}
		double sq=stdDeviation/count;
		return Math.sqrt(sq);
	}
	
}

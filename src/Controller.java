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
}

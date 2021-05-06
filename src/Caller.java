import java.util.List;

public class Caller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller=new Controller();
		//CREATE RUBRIC
		String name="Construction";
		Rubric rubric=controller.createRubric(name);
		//CREATE CRITERION
		String designCriterion="Design";
		String testingCriterion="Testing";
		//ADD CRITERION TO RUBRIC
		controller.addCriterionToRubric(rubric, designCriterion);
		controller.addCriterionToRubric(rubric, testingCriterion);
		//test
		System.out.println("rubric: "+rubric.getName());
		for(String criterion:rubric.getCriteria()) {
			System.out.println("Criterion "+criterion);
		}
		//GET LIST OF RUBRICS
		controller.getAllRubrics();
		//test
		for(Rubric rubric1:controller.getAllRubrics()) {
			System.out.println(rubric1.getName());
		}
		//GET RUBRIC BY NAME
		Rubric rubric2=controller.getRubricByName(name);
		System.out.println(rubric2.getName());
		//CREATE NEW STUDENT GRADE
		String student="Adam";
		int score=3;
		StudentGrade grade=controller.createStudentGrade(rubric,student,score);
		//ADD SCORE FOR PARTICULAR CRITERION TO A GRADE
		controller.addMark(grade, designCriterion, 4); 
		for (String i : grade.getMarks().keySet()) {
			  System.out.println("key: " + i + " value: " + grade.getMarks().get(i));
			}
		//GET ALL GRADES ASSOCIATED WITH A SPECIFIC RUBRIC
		List<StudentGrade> grades=controller.getAllGradesInRubric(rubric);
		//SUMMARY CALCULATIONS
		System.out.println("Average: "+ controller.getAverageForRubric(rubric));
		System.out.println("max: "+ controller.getMaxForRubric(rubric));
		System.out.println("min: "+ controller.getMinForRubric(rubric));
		System.out.println("stdv: "+ controller.getStandardDeviationForRubric(rubric));
		System.out.println("Average: "+ controller.getAverageForCriterion(rubric,designCriterion));
		System.out.println("max: "+ controller.getMaxForCriterion(rubric,designCriterion));
		System.out.println("min: "+ controller.getMinForCriterion(rubric,designCriterion));
		System.out.println("stdv: "+ controller.getStandardDeviationForCriterion(rubric,designCriterion));
	}

}

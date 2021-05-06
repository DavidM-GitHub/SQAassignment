import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class ComponentTest {
	private Controller controller;
   
	//TESTS IF CORRECT SCORE IS ADDED FOR CRITERION ON GRADE
   @Test	
   public void testAddMarkToGrade() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   grade.addMark(designCriterion,3);
	   assertEquals(1,grade.getMarks().size());
	   assertEquals(3,grade.getScore(designCriterion));
   }
   
   //TESTS IF EXCEPTION IS THROWN WHEN SCORE ADDED TO GRADE IS OUTSIDE VALID RANGE
   @Test(expected = IllegalArgumentException.class)	
   public void testAddInvalidMarkToGrade() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   grade.addMark(designCriterion,6);
   }
     
   @Before
   public void setUp() {
       this.controller = new Controller();
   }
   
   //TESTS IF RUBRIC IS CREATED AND ADDED TO LIST
   @Test	
   public void testCreateRubric() {
     Rubric rubric=controller.createRubric("Construction");
     assertEquals("Construction",rubric.getName());
     assertEquals(1,this.controller.getAllRubrics().size());
   }
   
   //TESTS IF CRITERION IS ADDED TO RUBRIC
   @Test	
   public void testAddCriterionToRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   assertEquals("Design",rubric.getCriteria().get(0));
   }
   
   //TESTS IF CRITERION IS ADDED TO RUBRIC
   @Test	
   public void testReachedMaxCriteriaInRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   for(int i=0;i<10;i++) {
	   controller.addCriterionToRubric(rubric, designCriterion);
	   }
	   assertEquals(10,rubric.getCriteria().size());
	   controller.addCriterionToRubric(rubric, designCriterion);
	   assertEquals(10,rubric.getCriteria().size());
   }
   
   //TESTS GETTTING RUBRIC BY NAME METHOD
   @Test	
   public void testGetRubricByName() {
	   Rubric rubric=controller.createRubric("Construction");
	   Rubric rubric2=controller.getRubricByName("Construction");
	   assertEquals("Construction",rubric2.getName());
   }
   
   //TESTS GETTTING RUBRIC BY NAME THAT DOESNT EXIST
   @Test(expected = NullPointerException.class)	
   public void testRubricNotFound() {
	   Rubric rubric=controller.createRubric("Construction");
	   Rubric rubric2=controller.getRubricByName("Business");
   }
   
   //TESTS CREATING STUDENT GRADE IN A RUBRIC
   @Test	
   public void testCreateStudentGrade() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   HashMap<String, Integer> marks=rubric.getGrades().get(0).getMarks();
	   assertEquals(new Integer(4),marks.get(designCriterion));
	   assertEquals(new Integer(4),marks.get(testingCriterion));
	   assertEquals("dave",grade.getName());
   }
  
   //TESTS IF GRADES WERE ADDED TO RUBRIC SUCCESSFULLY
   @Test	
   public void testGetGradesInRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(2,rubric.getGrades().size());
	   assertEquals("dave",rubric.getGrades().get(0).getName());
	   assertEquals("adam",rubric.getGrades().get(1).getName());
   }
   
   //TESTS IF AVERAGE OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testAverageForRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(3.5,controller.getAverageForRubric(rubric),0.001);
   }
   
   //TESTS IF MAXIMUM OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testMaxForRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(4,controller.getMaxForRubric(rubric),0.001);
   }
   
   //TESTS IF MINIMUM OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testMinForRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(3,controller.getMinForRubric(rubric),0.001);
   }
   
   //TESTS IF STANDARD DEVIATION OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testStandardDeviationForRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(0.5,controller.getStandardDeviationForRubric(rubric),0.001);
   }
   
   //TESTS IF AVERAGE OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testAverageForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(3.66,controller.getAverageForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF MAXIMUM OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testMaxForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(5,controller.getMaxForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF MINIMUM OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testMinForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(2,controller.getMinForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF STANDARD DEVIATION OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testStandardDeviationForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(1.24,controller.getStandardDeviationForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF CONTROLLER ADDS MARK TO CRITERION
   @Test	
   public void testControllerAddScoreToCriterion() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   controller.addMark(grade,designCriterion,3);
	   assertEquals(1,grade.getMarks().size());
	   assertEquals(3,grade.getScore(designCriterion));
   }
   
   //TESTS IF CONTROLLER RETRIEVES ALL GRADES FOR A SPECIFIC RUBRIC
   @Test	
   public void testControllerGetGradesInRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(2,controller.getAllGradesInRubric(rubric).size());
	   assertEquals("dave",controller.getAllGradesInRubric(rubric).get(0).getName());
	   assertEquals("adam",controller.getAllGradesInRubric(rubric).get(1).getName());
   }
}


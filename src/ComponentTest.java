import static org.junit.Assert.assertEquals;

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
  
}


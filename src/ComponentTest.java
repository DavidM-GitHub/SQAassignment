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
  
}


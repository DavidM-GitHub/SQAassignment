import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class ComponentTest {
   
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
  
}


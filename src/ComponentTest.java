import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class ComponentTest {
   
   @Test	
   public void testAddMarkToGrade() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   grade.addMark(designCriterion,3);
	   assertEquals(1,grade.getMarks().size());
	   assertEquals(3,grade.getScore(designCriterion));
   }
   
   @Test(expected = IllegalArgumentException.class)	
   public void testAddInvalidMarkToGrade() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   grade.addMark(designCriterion,6);
   }
  
}


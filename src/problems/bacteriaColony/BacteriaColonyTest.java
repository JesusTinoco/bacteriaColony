package problems.bacteriaColony;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BacteriaColonyTest {
	IBacteriaColonyProblem colonyProblem;
	
	@Before
	public void setup() {
		colonyProblem = new BacteriaColonyProblem();
	}
	
	@Test
	public void testBacteriaProblem1Iter1() {
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		boolean [][]expected = {{false,true,true,false},
								{false,true,true,true},
								{false,false,true,true},
								{false,false,false,false}};
		colonyProblem.setData(4,1,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem1Iter2() {
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		boolean [][]expected = {{false,true,false,true},
								{false,false,false,false},
								{false,true,false,true},
								{false,false,false,false}};
		colonyProblem.setData(4,2,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem2() {
		int [][]bacteria = {{1,1}};
		boolean [][]expected = {{false,false,false},
								{false,false,false},
								{false,false,false}};
		colonyProblem.setData(3,1,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem3Iter1() {
		int [][]bacteria = {{1,1},{2,1},{2,2}};
		boolean [][]expected = {{false,false,false},
								{false,true,true},
								{false,true,true}};
		colonyProblem.setData(3,1,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem3Iter2() {
		int [][]bacteria = {{1,1},{2,1},{2,2}};
		boolean [][]expected = {{false,false,false},
								{false,true,true},
								{false,true,true}};
		colonyProblem.setData(3,16,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem4() {
		int [][]bacteria = {{1,1},{2,1},{2,2}};
		boolean [][]expected = {{false,false,false,false,false},
								{false,true,true,false,false},
								{false,true,true,false,false},
								{false,false,false,false,false},
								{false,false,false,false,false}};
		colonyProblem.setData(5,15,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testBacteriaIllegalData() {
		colonyProblem.setData(0,1,null);
	}
	
	private void checkResult (boolean[][] expected, boolean[][] result) {
		Assert.assertEquals("Colony width error", expected.length, result.length);
		for (int x = 0; x < result.length; x++) {
			Assert.assertEquals("Colony height error", expected[x].length, result[x].length);
			for (int y = 0; y < result[x].length; y++)
				Assert.assertEquals ("Incorrect value at ["+x+","+y+"]",
									expected[x][y], result[x][y]);
		}	
	}


}

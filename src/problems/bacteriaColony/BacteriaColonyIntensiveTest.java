package problems.bacteriaColony;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BacteriaColonyIntensiveTest {
	IBacteriaColonyProblem colonyProblem;
	
	@Before
	public void setup() {
		colonyProblem = new BacteriaColonyProblem();
	}
	
	@Test
	public void testBacteriaProblem1DoubleSetData() {
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		boolean [][]expected = {{false,true,true,false},
								{false,true,true,true},
								{false,false,true,true},
								{false,false,false,false}};
		colonyProblem.setData(4,1,bacteria);
		colonyProblem.setData(4,1,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem1Iter2TwoRun() {
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		boolean [][]expected = {{false,true,false,true},
								{false,false,false,false},
								{false,true,false,true},
								{false,false,false,false}};
		colonyProblem.setData(4,2,bacteria);
		colonyProblem.run();
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test
	public void testBacteriaProblem2() {
		colonyProblem.run();
	}
	
	@Test
	public void testBacteriaProblemTwoSetData() {
		int [][]unusedBacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		colonyProblem.setData(4,2,unusedBacteria);
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		boolean [][]expected = {{false,true,true,false},
								{false,true,true,true},
								{false,false,true,true},
								{false,false,false,false}};
		colonyProblem.setData(4,1,bacteria);
		colonyProblem.run();
		checkResult(expected,colonyProblem.getResult());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testBacteriaIllegalData() {
		int [][]bacteria = {{0,2},{1,1},{1,2},{2,2},{3,2}};
		colonyProblem.setData(-1,-1,bacteria);
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

package problems.bacteriaColony;

public interface IBacteriaColonyProblem {
	/*
	 * This method sets the input data for the problem.
	 * @param size Width and height of the colony, i.e. size=4 creates a 4x4 matrix.
	 * @param transitions Number of transition steps to compute in the problem.
	 * @param bacteriaPosition An array of bacteria positions as (i,j) pairs
	 * such that 0 <= i,j < size.
	 * @throws IllegalArgumentException if bacteriaPosition is null, size or 
	 * transitions are 0 or negative numbers, 
	 * or the bacteriaPosition is not a list of pairs. 
	 */

	public abstract void setData(int size, int transitions, int [][]bacteriaPosition);
	
	/*
	 * Executes the problem if the data has been correctly set
	 */

	public abstract void run();
	
	/*
	 * @return a boolean matriz of size x size dimensions. True value indicates a living bacteria; 
	 * false value represents an empty space.
	 */
	public abstract boolean[][] getResult();
}
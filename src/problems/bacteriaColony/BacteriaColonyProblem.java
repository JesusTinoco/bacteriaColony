package problems.bacteriaColony;

import java.util.ArrayList;
import java.util.List;

public class BacteriaColonyProblem implements IBacteriaColonyProblem {

	private Integer size;
	private Integer transitions;
	private int[][] bacteriaPosition;
	private boolean runnable = false;
	private boolean executed = false;

	@Override
	public void setData(int size, int transitions, int [][]bacteriaPosition) {

		if(size <= 0)
			throw new IllegalArgumentException();
		if(transitions <= 0)
			throw new IllegalArgumentException();
		if(bacteriaPosition == null || !bacteriaPositionCheck(bacteriaPosition))
			throw new IllegalArgumentException();

		this.size = size;
		this.transitions = transitions;
		this.bacteriaPosition = bacteriaPosition;
		this.runnable = true;

	}

	@Override
	public void run() {

		if(runnable && !executed){
			for(int trans = 0; trans<transitions; trans++){			

				List<int[]> list = new ArrayList<int[]>();

				for(int i = 0; i < size; i++){
					for(int j = 0; j < size; j++){

						int[] pos = {i, j};
						int neighbours = countNeighbours(pos);

						if(isThereBacteria(pos)){
							if(neighbours > 1 && neighbours < 4)
								list.add(pos);
						} else {
							if(neighbours == 3)
								list.add(pos);
						}

					}
				}

				int[][] newBacteriaPositions = new int[list.size()][2];
				for(int i = 0; i<list.size(); i++){
					newBacteriaPositions[i] = list.get(i);
				}

				bacteriaPosition = newBacteriaPositions;
				executed = true;
			}
		}

	}

	@Override
	public boolean[][] getResult() {
		boolean[][] res = new boolean[size][size];

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				res[i][j] = false;
			}
		}

		for(int[] pos: bacteriaPosition){
			res[pos[0]][pos[1]] = true;
		}

		return res;
	}

	private boolean isThereBacteria(int[] position){
		boolean res = false;

		for(int i = 0; i<bacteriaPosition.length; i++){
			if(bacteriaPosition[i][0] == position[0] &&
					bacteriaPosition[i][1] == position[1]){
				res = true;
				break;
			}
		}

		return res;
	}

	private int countNeighbours (int[] position){

		int res = 0;
		int[][] positions = new int[8][2];

		int[] tlc = {position[0] - 1, position[1] - 1};
		positions[0] = tlc;
		int[] t = {position[0], position[1] - 1};
		positions[1] = t;
		int[] trc = {position[0] - 1, position[1] + 1};
		positions[2] = trc;
		int[] l = {position[0] - 1, position[1]};
		positions[3] = l;
		int[] r = {position[0], position[1] + 1};
		positions[4] = r;
		int[] blc = {position[0] + 1, position[1] - 1};
		positions[5] = blc;
		int[] b = {position[0] + 1, position[1]};
		positions[6] = b;
		int[] brc = {position[0] + 1, position[1] + 1};
		positions[7] = brc;

		for(int i = 0; i<positions.length; i++){
			for(int j = 0; j<bacteriaPosition.length; j++){
				if(positions[i][0] == bacteriaPosition[j][0] &&
						positions[i][1] == bacteriaPosition[j][1]){
					res++;
					break;
				}
			}
		}

		return res;
	}

	private boolean bacteriaPositionCheck(int[][] bacteriaPosition){
		boolean res = true;
		for(int i = 0; i < bacteriaPosition.length; i++){
			if(bacteriaPosition[i].length != 2){
				res = false;
				break;
			}
		}
		return res;
	}


}

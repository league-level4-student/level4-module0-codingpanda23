package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
			Cell randCell = new Cell(0, h);
		
			
		//5. call selectNextPath method with the randomly selected cell
			selectNextPath(randCell);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
			currentCell.setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
			ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
			if (!neighbors.isEmpty()) {
			//C1. select one at random.
				uncheckedCells.push(neighbors.get(0));
			//C2. push it to the stack
				
			//C3. remove the wall between the two cells
				removeWalls(currentCell, neighbors.get(0));
			//C4. make the new cell the current cell and mark it as visited
				currentCell = neighbors.get(0);
				currentCell.hasBeenVisited();
			//C5. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		//D. if all neighbors are visited
			if (neighbors.isEmpty()) {
			//D1. if the stack is not empty
				if (!uncheckedCells.isEmpty()) {
				// D1a. pop a cell from the stack
					Cell poppedCell = uncheckedCells.pop();
				// D1b. make that the current cell
					currentCell = poppedCell;
				// D1c. call the selectNextPath method with the current cell
					selectNextPath(currentCell);
				}	
			}
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getX()) {
			
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}

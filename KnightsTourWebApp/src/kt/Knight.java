package kt;
import java.util.ArrayList;
import java.util.Arrays;

class Knight {
	private int numMoves = 1;
	private boolean isMovable = true;
	private int[] currentPos = new int[2];
	private int[] startingPos = new int[2];
	private ArrayList<int[]> possibleMoveIndexes = this.createPossibleMoveIndexes();
	private ArrayList<int[]> previousPositions = new ArrayList<int[]>();
	
	// when Knight is first initialized, 
	// randomly select its first position on the board
	Knight(Square[][] squares) {
		int randomRow = Utilities.randomNum(7);
		int randomCol = Utilities.randomNum(7);
		
		this.currentPos = new int[] {randomRow, randomCol};
		this.startingPos = this.currentPos;
		this.previousPositions.add(this.currentPos);
	}
	
	Knight(Square[][] squares, int[] startingPos) {
		this.currentPos = startingPos;
		this.startingPos = this.currentPos;
		this.previousPositions.add(this.currentPos);
	}
	
	String getStartingPos() {
		return Arrays.toString(this.startingPos);
	}
	
	boolean isMovable() {
		return isMovable;
	}
	
	void setMovable(boolean isMovable) {
		this.isMovable = isMovable;
	}
	
	// return Knights current position
	int[] getCurrentPosition() {
		return this.currentPos;
	}

	int getNumMoves() {
		return numMoves;
	}

	void setNumMoves(int moves) {
		this.numMoves = moves;
	}
	
	void move(Square[][] squares) {		
		int[] randomMove = new int[2];
		try {
			 randomMove = this.selectRandomPossibleMove();
			 if (isMovable) {
					Square currentSqr = squares[currentPos[0]][currentPos[1]];
					previousPositions.add(currentPos);
					currentSqr.setMoveNum(numMoves);
					currentSqr.setName(String.valueOf(numMoves));
					numMoves++;
					
					squares[randomMove[0]][randomMove[1]].setName("K");
					currentPos = randomMove;
				}
		} catch(Exception ex) {
			isMovable = false;
		}
	}
	
	void smartMove(Square[][] squares) {
		int[] move = new int[2];
		try {
			move = this.selectSmartMove(squares);
			 if (isMovable) {
					Square currentSqr = squares[currentPos[0]][currentPos[1]];
					previousPositions.add(currentPos);
					currentSqr.setMoveNum(numMoves);
					currentSqr.setName(String.valueOf(numMoves));
					numMoves++;
					
					squares[move[0]][move[1]].setName("K");
					currentPos = move;
				}
		} catch(Exception ex) {
			isMovable = false;
		}
	}
	
	private int[] selectSmartMove(Square[][] squares) {
		ArrayList<int[]> possibleMoves = this.getPossibleMoves();
		
		int indexOfSmallestAccessibleMove = 0;
		int accessibility = 8;
		for(int i = 0; i < possibleMoves.size();i++) {
			int[] currentMove = possibleMoves.get(i);
			int squareAccessNum = squares[currentMove[0]][currentMove[1]].getAccessibility();
			if(squareAccessNum <= accessibility) {
				indexOfSmallestAccessibleMove = i;
			}
		}
		
		return possibleMoves.get(indexOfSmallestAccessibleMove);
	}

	private int[] selectRandomPossibleMove() {
		ArrayList<int[]> possibleMoves = this.getPossibleMoves();
		if (possibleMoves.size() == 1) {
			return possibleMoves.get(possibleMoves.size() - 1);
		}
		int randomMoveIdx = Utilities.randomNum(possibleMoves.size() - 1);
		return possibleMoves.get(randomMoveIdx);
	}
	
	private ArrayList<int[]> getPossibleMoves() {
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		
		for(int i = 0; i < possibleMoveIndexes.size(); i++) {
			int[] idx = possibleMoveIndexes.get(i);
			int[] possibleMove = Utilities.addArrays(idx, currentPos);
			boolean isPrevious = false;
			if((possibleMove[0] <= 7 && possibleMove[0] >= 0) && (possibleMove[1] <=7  && possibleMove[1] >= 0)) {
				for(int j = 0; j < previousPositions.size(); j++) {
					if (Arrays.equals(previousPositions.get(j), possibleMove)) {
						isPrevious = true;
					}
				}
				if (!isPrevious)
					possibleMoves.add(possibleMove);
				isPrevious = false;
			}
		}
		
		return possibleMoves;
	}
	
		
	// possible moves of a knight with 8 movable areas
	private ArrayList<int[]> createPossibleMoveIndexes() {
		ArrayList<int[]> possibleMovesIndexes = new ArrayList<int[]>();
		int[] idxZero = {-1, 2};
		int[] idxOne = {-2, 1};
		int[] idxTwo = {-2, -1};
		int[] idxThree = {-1, -2};
		int[] idxFour = {1, 2};
		int[] idxFive = {2, -1};
		int[] idxSix = {2, 1};
		int[] idxSeven = {1, -2};
		
		possibleMovesIndexes.add(idxZero);
		possibleMovesIndexes.add(idxOne);
		possibleMovesIndexes.add(idxTwo);
		possibleMovesIndexes.add(idxThree);
		possibleMovesIndexes.add(idxFour);
		possibleMovesIndexes.add(idxFive);
		possibleMovesIndexes.add(idxSix);
		possibleMovesIndexes.add(idxSeven);
		
		return possibleMovesIndexes;
	}
}

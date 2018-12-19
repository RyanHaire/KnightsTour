package kt;
import java.io.PrintWriter;
import java.util.ArrayList;

class Board {

	private Square[][] squares;
	private ArrayList<int[]> possibleMoveIndexes = this.createPossibleMoveIndexes();
	
	Board() {
		this.squares = this.createBoard();
		this.setSquareAccessbility();
	}
	
	
	// print board squares with row numbers
	void print(PrintWriter out) {
		out.println('\n');
		// loop through rows
		for(int i = 0; i < squares.length; i++) {
			// loop through columns
			for(int j = 0; j < squares[i].length; j++) {
				squares[i][j].setPosition(i, j);
				out.print("&nbsp; &nbsp;" + squares[i][j].getName() + "&nbsp; &nbsp;");
			}
			out.println("<br/>");
		}
	}
	
	// set knight position on board and set to K to show 
	void setKnightPosition(int[] pos) {
		this.squares[pos[0]][pos[1]].setName("K");
	}
	
	// return board squares
	Square[][] getBoardSquares() {
		return this.squares;
	}
	
	// create board method 
	private Square[][] createBoard() {
		Square[][] squares = new Square[8][8];
		for(int i = 0; i < squares.length; i++) {
			for(int j = 0; j < squares[i].length; j++) {
				squares[i][j] = new Square();
				squares[i][j].setPosition(i, j);
			}
		}
		return squares;
	}
	
	
	private void setSquareAccessbility() {
		
		for(int i = 0; i < squares.length; i++) {
			for(int j = 0; j < squares[i].length; j++) {
				int accessNum = possibleSquareMoves(squares[i][j].getPosition());
				squares[i][j].setAccessibility(accessNum);
			}
		}
	}
	
	private int possibleSquareMoves(int[] squarePos) {
		ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
		
		for(int i = 0; i < possibleMoveIndexes.size(); i++) {
			int[] idx = possibleMoveIndexes.get(i);
			int[] possibleMove = Utilities.addArrays(idx, squarePos);
			
			if((possibleMove[0] <= 7 && possibleMove[0] >= 0) && (possibleMove[1] <=7  && possibleMove[1] >= 0)) {
				possibleMoves.add(possibleMove);
			}
		}
	
		return possibleMoves.size();
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

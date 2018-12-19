package kt;
import java.io.PrintWriter;

public class KnightsTour {
	Board board = new Board();
	Knight knight;
	PrintWriter out;
	
	public KnightsTour(PrintWriter out) {
		this.out = out;
		this.knight = new Knight(board.getBoardSquares());
		this.board.setKnightPosition(knight.getCurrentPosition());
	}
	
	public KnightsTour(PrintWriter out, int[] knightStartingPos) {
		this.out = out;	
		this.knight = new Knight(board.getBoardSquares(), knightStartingPos);
		this.board.setKnightPosition(knight.getCurrentPosition());
	}
	
	public void runNonIntelligentMethod() {
		while(knight.isMovable()) {
			knight.move(board.getBoardSquares());
		}
	}
	
	public void runHeuristicMethod() {
		while(knight.isMovable()) {
			knight.smartMove(board.getBoardSquares());
		}
	}
	
	public void printBoard() {
		board.print(this.out);
	}
	
	public int getTourMoves() {
		return knight.getNumMoves();
	}
	
	public String getKnightStartingPos() {
		return knight.getStartingPos();
	}
}

/**
 * 
 */
package tictactoe;

/**
 * Abstract Player class
 *
 */
public abstract class Player {
	protected char mark;
	
	Player(char mark) {
		this.mark = mark;
	}
	
	public abstract int getMove(GameBoard board) throws Exception;
	
	public void playMove(GameBoard board) throws Exception {
		board.set(getMove(board), mark);
	}
	
	public char getMark() {
		return mark;
	}
}

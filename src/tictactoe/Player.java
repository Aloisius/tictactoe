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
	
	public abstract void playMove(GameBoard board) throws Exception;
}

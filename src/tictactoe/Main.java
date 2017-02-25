/**
 * 
 */
package tictactoe;

/**
 * Start a tic-tac-toe game
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameBoard board = new GameBoard("XXXXOOOOX");
		
		System.out.println(board.toString());
	}

}

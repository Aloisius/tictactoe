/**
 * 
 */
package tictactoe;

/**
 * Representation of the game board
 *
 */
public class GameBoard {
	private char[] state;
	
	public final char CROSS = 'X';
	public final char NAUGHT = 'O';
	public final char UNPLAYED = ' ';
	
	
	public GameBoard() {
		state = "         ".toCharArray();
	}
	
	public GameBoard(String state) {
		this.state = state.toCharArray();
	}
	
	// Is the game won?
	public boolean won() {		
		int[][] winningMoves = new int[][] {
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},

			{0, 4, 8},
			{2, 4, 6}			
		};
		
		for (int i = 0; i < winningMoves.length; i++) {
			if (state[winningMoves[i][0]] != UNPLAYED && 
					state[winningMoves[i][0]] == state[winningMoves[i][1]] && 
							state[winningMoves[i][0]] == state[winningMoves[i][2]]) {
				return true;
			}
		}
		return false;
	}
	
	public String toString () {
		StringBuilder code = new StringBuilder(9);
		
		for (int i = 0; i < state.length; i++) {
			code.append(" " + state[i] + " ");
			
			switch ((i + 1) % 3) {
			case 0:
				if (i != 8) {
					code.append("\n-------------\n");
				}
				break;
			default:
				code.append(" |");
			}
		}
		
		return code.toString();
	}
}

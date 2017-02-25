/**
 * 
 */
package tictactoe;

/**
 * Representation of the game board
 *
 */
public class GameBoard {
	private String state = "         ";
	
	public GameBoard() {
	}
	
	public GameBoard(String state) {
		this.state = state;
	}
	
	public boolean won() {
		return false;
	}
	
	public String toString () {
		StringBuilder code = new StringBuilder(9);
		
		for (int i = 0; i < state.length(); i++) {
			code.append(" " + state.charAt(i) + " ");
			
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

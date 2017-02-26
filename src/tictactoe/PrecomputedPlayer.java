/**
 * 
 */
package tictactoe;

/**
 * Uses the the Precomputed Moves class to play the game
 *
 */
public class PrecomputedPlayer extends Player {
	PrecomputedMoves precomputedMoves = new PrecomputedMoves();

	PrecomputedPlayer(char mark) {
		super(mark);
	}

	
	@Override
	public int getMove(GameBoard board) throws Exception {
		return precomputedMoves.states.get(String.valueOf(board.getState()));
	}

}

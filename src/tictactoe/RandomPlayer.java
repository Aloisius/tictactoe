/**
 * 
 */
package tictactoe;

import java.util.Collection;
import java.util.Optional;


/**
 * Random Player
 *
 */
public class RandomPlayer extends Player {
	public RandomPlayer(char mark) {
		super(mark);
	}
	

	@Override
	public int getMove(GameBoard board) throws Exception {
		Collection<Integer> availableMoves = board.availableMoves();

		Optional<Integer> move = availableMoves.stream().skip((long)(availableMoves.size() * Math.random())).findFirst();
		return move.get();
	}
}

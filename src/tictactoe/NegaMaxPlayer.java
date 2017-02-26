/**
 * 
 */
package tictactoe;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Uses the negamax algorithm to find the best move
 *
 *  function negamax(node, depth, color)
 *     if depth = 0 or node is a terminal node
 *         return color * the heuristic value of node
 *
 *    bestValue := −∞
 *    foreach child of node
 *        v := −negamax(child, depth − 1, −color)
 *        bestValue := max( bestValue, v )
 *    return bestValue
 *
 *  # Initial call for Player A's root node
 *  rootNegamaxValue := negamax( rootNode, depth, 1)
 *  rootMinimaxValue := rootNegamaxValue
 *
 *  # Initial call for Player B's root node
 *  rootNegamaxValue := negamax( rootNode, depth, −1)
 *  rootMinimaxValue := −rootNegamaxValue
 */
public class NegaMaxPlayer extends Player {
	private char opponentMark;
	
	public NegaMaxPlayer(char mark) {
		super(mark);
		
		if (mark == GameBoard.CROSS) {
			opponentMark = GameBoard.NAUGHT;
		} else {
			opponentMark = GameBoard.CROSS;
		}
	}
	
	private char getColorMark(int color) {
		if (color == -1) {
			return mark;
		}

		return opponentMark;
	}
	
	@Override
	public int getMove(GameBoard board) throws Exception {
		Entry<Integer, Integer> bestMove = negamax(board, -1);
		return bestMove.getValue();
	}
	
    public Map.Entry<Integer, Integer> negamax(GameBoard board, int color) {
        if (!board.inProgress()) {
          return new AbstractMap.SimpleEntry<Integer, Integer>(score(board, getColorMark(color)), null);
        }

        
        Map.Entry<Integer, Integer> bestValue = new AbstractMap.SimpleEntry<>(Integer.MIN_VALUE, null);
		for (int move : board.availableMoves()) {
			GameBoard childBoard = new GameBoard(board);
			childBoard.set(move, getColorMark(color));
			Map.Entry<Integer, Integer> childValue = negamax(childBoard, -color);
			if (-childValue.getKey() > bestValue.getKey()) {
				bestValue = new AbstractMap.SimpleEntry<>(-childValue.getKey(), move);
			}			
		}
		
		return bestValue;
    }
    
    // Scores a game state for a particular player
    public int score(GameBoard board, char playerMark) {
        if (board.loser(playerMark)) {
            return -1000;
        }
        
        
        if (board.winner(playerMark)) {
            return 1000;
        }
    	
        // TODO: replace with actual scoring code so negamax() can have a max depth for adjusting intelligence        
    	return 0;
    }
}

/**
 * 
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Representation of the game board
 *
 */
public class GameBoard {
	private char[] state;
	
	public static final char CROSS = 'X';
	public static final char NAUGHT = 'O';
	public static final char UNPLAYED = ' ';
	
	
	public GameBoard() {
		state = "         ".toCharArray();
	}
	
	public GameBoard(String state) {
		this.state = state.toCharArray();
	}
	
	public GameBoard(GameBoard board) {
		this.state = board.getState().clone();
	}

	
	// Is the game in progress?
	public boolean inProgress() {
		if (won()) {
			return false;
		}

		for (int i = 0; i < state.length; i++) {
			if (state[i] == UNPLAYED) {
				return true;
			}
		}
		return false;
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
	
	// are there any spaces available?
	public boolean isAvailableMoves() {
		for (int i = 0; i < state.length; i++) {
			if (state[i] == UNPLAYED) {
				return true;
			}
		}
		return false;
	}
	
	// Check to see if a particular move is available (zero-indexed)
	public boolean available(int move) {
		if (move < 0 || move > 8) {
			return false;
		}
		
		return state[move] == UNPLAYED;
	}
	
	// Set a move to player mark
	public void set(int move, char mark) {
		if (move < 0 || move > 8) {
			return; // fixme: throw exception
		}
		
		state[move] = mark;
	}
		
	// Returns an array of valid moves
	public Collection<Integer> availableMoves() {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		for (int i = 0; i < state.length; i++) {
			if (state[i] == UNPLAYED) {
				moves.add(i);
			}
		}
		
		return moves;
	}
	
	// Get the internal board state
	public char[] getState() {
		return state;
	}
	
	// Did this player win?
	public boolean winner(char player) {
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
			if (state[winningMoves[i][0]] == player && 
					state[winningMoves[i][0]] == state[winningMoves[i][1]] && 
							state[winningMoves[i][0]] == state[winningMoves[i][2]]) {
				return true;
			}
		}
		return false;		
	}
	
	// Did this player lose?
	public boolean loser(char player) {
		if (won() && !winner(player)) {
			return true;
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

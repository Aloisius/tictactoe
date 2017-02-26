/**
 * 
 */
package tictactoe;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;

/**
 * Creates the PrecomplatedMoves.java file for precomputed perfect play using NegaMax
 *
 */
public class PrecomputedMoveGenerator {
	public static HashMap<String, Integer> states = new HashMap<String, Integer>();
	
	public static void playRecusively(GameBoard board, Player opponent) throws Exception {
		Collection<Integer> availableMoves = board.availableMoves();

		for (int move : availableMoves) {
			GameBoard boardCopy = new GameBoard(board);
			boardCopy.set(move, GameBoard.CROSS);
			
			if (!boardCopy.inProgress()) {
				continue;
			}
			
			if (states.containsKey(String.valueOf(boardCopy.getState()))) {
				continue;
			}
			
			int bestMove = opponent.getMove(boardCopy);
			//System.out.println(String.copyValueOf(boardCopy.getState()) + " -> " + bestMove);
			states.put(String.copyValueOf(boardCopy.getState()), bestMove);
			boardCopy.set(bestMove, opponent.getMark());
			
			if (boardCopy.inProgress()) {
				playRecusively(boardCopy, opponent);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		GameBoard board = new GameBoard();
		Player opponent = new NegaMaxPlayer(GameBoard.NAUGHT);
		
		playRecusively(board, opponent);
		
		PrintWriter writer = new PrintWriter("PrecomputedMoves.java");

		writer.println("package tictactoe;\n");
		writer.println("import java.util.HashMap;\n");
		writer.println("class PrecomputedMoves {");
		writer.println("  public HashMap<String, Integer> states = new HashMap<String, Integer>();\n");
		writer.println("  public  PrecomputedMoves() {");
		
	    for (HashMap.Entry<String, Integer> entry : states.entrySet()) {
	        //System.out.println(entry.getKey() + " -> " + entry.getValue());
	    	writer.println("    states.put(\"" + entry.getKey() + "\", " + entry.getValue() + ");");
	    }
	    writer.println("  }");
	    writer.println("}");
	    
	    writer.close();
	}

}

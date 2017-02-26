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
	
	public static void main(String[] args) throws Exception {
		GameBoard board = new GameBoard();
		Player player = new InteractivePlayer(GameBoard.CROSS);
		//Player opponent = new RandomPlayer(GameBoard.NAUGHT);
		//Player opponent = new NegaMaxPlayer(GameBoard.NAUGHT);
		Player opponent = new PrecomputedPlayer(GameBoard.NAUGHT);

		while (board.isAvailableMoves()) {
	        System.out.println("\n" + board);

			player.playMove(board);
			
			if (board.won()) {
				System.out.println("Congratulations: you won!");
				break;
			} else if (!board.isAvailableMoves()) {
				System.out.println("A draw");
				break;
			}
			
			opponent.playMove(board);
			System.out.println(board);

			if (board.won()) {
				System.out.println("You lose");
				break;
			} else if (!board.isAvailableMoves()) {
				System.out.println("A draw");
				break;
			}
			
			System.out.println(board.toString());
		}
		
	}

}

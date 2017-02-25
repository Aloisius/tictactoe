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
		GameBoard board = new GameBoard();
		InteractivePlayer player = new InteractivePlayer(GameBoard.CROSS);
		RandomPlayer opponent = new RandomPlayer(GameBoard.NAUGHT);
		
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
			
			try { 
				opponent.playMove(board);
			} catch (Exception e) {
				break;
			}

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

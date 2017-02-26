/**
 * 
 */
package tictactoe;

import java.util.Scanner;


/**
 * An interactive player
 *
 */
public class InteractivePlayer extends Player {
	public InteractivePlayer(char mark) {
		super(mark);
	}
	
	@Override
	public void playMove(GameBoard board) {
		Scanner input = new Scanner(System.in);
		
	    while (true) {
		    System.out.print("Enter which position you want to check (1-9): ");
	        int move = input.nextInt() - 1;   
	        
	        if (move < 0 || move > 8) {
	        	System.out.println(move);
	        	System.out.println("You must pick a space between 1 and 9\n");
	        	continue;
	        } else if (!board.available(move)) {
	        	System.out.println("That space isn't available, choose another\n");
	        	continue;
	        } else {
	        	board.set(move, mark);
	        	break;
	        }
	    }
	}
}

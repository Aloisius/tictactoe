package tictactoe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWon() {;
		assertTrue(new GameBoard("XXXXOOOOX").won());
		assertFalse(new GameBoard("         ").won());
	}

}

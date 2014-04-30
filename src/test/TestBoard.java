package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Constants;
import core.Game;
import core.Tile;

public class TestBoard {

	@Test
	public void testMovingUp() {
		Game g = new Game();
		Tile[][] b = { { null, null, null, null },
				{ new Tile(), null, null, null }, { null, null, null, null },
				{ null, null, null, null } };
		g.setBoard(b);
		g.move(Constants.UP);
		assertTrue(g.toString().startsWith("2 "));
	}

	@Test
	public void testMovingDown() {
		Game g = new Game();
		Tile[][] b = { { null, null, null, null }, { null, null, null, new Tile() },
				{ null, null, null, null }, { null, null, null, null } };
		g.setBoard(b);
		g.move(Constants.DOWN);
		assertTrue(g.toString().trim().endsWith(" 2"));
	}
	
	@Test
	public void testMergeUp(){
		Game g = new Game();
		Tile[][] b = { { new Tile(), null, null, null },
				{ new Tile(), new Tile(), null, null }, { null, new Tile(), null, null },
				{ null, null, null, null } };
		g.setBoard(b);
		g.move(Constants.UP);
		assertTrue(g.toString().startsWith("4 4"));
	}
	
	@Test
	public void testMergeDown(){
		Game g = new Game();
		Tile[][] b = { 
				{ null, null, new Tile(), null },
				{ null, null, null, new Tile()},
				{ null, null, new Tile(), null},
				{ null, null, null, new Tile()} };
		g.setBoard(b);
		g.move(Constants.DOWN);
		assertTrue(g.toString().trim().endsWith("4 4"));
	}
}

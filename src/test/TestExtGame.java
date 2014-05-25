package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ai.Play;

import core.Game;
import core.Tile;

public class TestExtGame {

	@Test
	public void test() {
		Tile[][] b = { { new Tile(), null, null, null },
				{ new Tile(), new Tile(), null, null },
				{ null, new Tile(), null, null }, { null, null, null, null } };
		Game g = new Game();
		g.setBoard(b);
		Play p = new Play(g);
		g.setBoard(b);
		assertTrue(p.getGame().getQueue().toString().startsWith("[2, 2, null"));
		assertEquals(-3, p.score());
		Tile[][] c = { { new Tile(256), null, null, null },
				{ new Tile(64), new Tile(2), null, null },
				{ new Tile(32), new Tile(4), null, null },
				{ new Tile(8), new Tile(8), null, null } };
		g.setBoard(c);
		p = new Play(g);
		System.out.println(p.getGame());
		assertEquals(5, p.score());
	}
}

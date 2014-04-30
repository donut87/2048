package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Tile;

public class TestTiles {

	@Test
	public void testEqualty() {
		Tile t1 = new Tile();
		Tile t2 = new Tile();
		assertFalse(t1 == t2);
		assertEquals(t1, t2);
	}

	@Test
	public void testMerge() {
		Tile t1 = new Tile();
		Tile t2 = new Tile();
		Tile t3 = new Tile(t1,t2);
		assertEquals(t3.getValue(), 4);
	}
	
	@Test
	public void testNullComparison(){
		Tile t1 = new Tile();
		assertFalse(t1.equals(null));
	}

}

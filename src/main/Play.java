package main;

import core.Constants;
import core.Game;

public class Play {

	public static void main(String[] args) {
		Game g = new Game();
		System.out.println(g.toString());
		System.out.println(g.canMoveDown());
		System.out.println(g.canMoveUp());
		System.out.println(g.canMoveRight());
		System.out.println(g.canMoveLeft());
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveLeft())
			g.move(Constants.LEFT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveRight())
			g.move(Constants.RIGHT);
		System.out.println(g);
		if (g.canMoveDown())
			g.move(Constants.DOWN);
		System.out.println(g);
		if (g.canMoveDown())
			g.move(Constants.DOWN);
		System.out.println(g);
		if(g.canMoveUp())
			g.move(Constants.UP);
		System.out.println(g);
		if(g.canMoveUp())
			g.move(Constants.UP);
		System.out.println(g);
		
	}

}

package ai;

import java.util.ArrayList;
import java.util.Collections;

import core.Game;
import core.Tile;

public class Play {

	ExtGame g = null;

	public Play(Game g) {
		this.g = new ExtGame(g.getBoard());
	}

	public ExtGame getGame() {
		return this.g;
	}

	public class ExtGame extends Game {

		public ExtGame(Tile[][] b) {
			Tile[][] newBoard = new Tile[this.getSize()][this.getSize()];
			for (int i = 0; i < this.getSize(); i++)
				for (int j = 0; j < this.getSize(); j++)
					newBoard[i][j] = ((b[i][j] == null) ? null : b[i][j]
							.clone());
			this.setBoard(newBoard);
		}

		public ArrayList<Tile> getQueue() {
			int mode = 1;
			ArrayList<Tile> result = new ArrayList<Tile>();
			for (int height = 0; height < this.getSize(); height++) {
				for (int width = (mode > 0) ? 0 : this.getSize() - 1; ((mode > 0) ? width < this
						.getSize() : width >= 0); width += mode) {
					result.add(this.getBoard()[width][height]);
				}
				mode *= -1;
			}
			return result;
		}
	}

	public int score() {
		// Plan: start in the upper left corner. if the tiles to the left and
		// bottom are less or equal this is a plus
		// TODO: decide what happens on empty tiles...
		int result = 0;
		ArrayList<Tile> a = g.getQueue();
		Collections.reverse(a);
		int index = 0;
		while (a.get(index) == null)
			index++;
		for (int i = index; i < a.size() - 1; i++) {
			if (a.get(i) == null)
				continue;
			int cmp = a.get(i).compareTo(a.get(i + 1));
			result -= cmp;
		}
		return result;
	}
}

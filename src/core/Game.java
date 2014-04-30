package core;

import java.util.Random;

public class Game {

	private Tile[][] board;
	private final int size = 4;

	public Game() {
		this.setBoard(new Tile[size][size]);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.getBoard()[i][j] = null;
			}
		}
		Random r = new Random();
		this.getBoard()[r.nextInt(size)][r.nextInt(size)] = new Tile();
	}

	public void move(int direction) {
		switch (direction) {
		case Constants.LEFT:
			moveLeft();
			break;
		case Constants.RIGHT:
			moveRight();
			break;
		case Constants.DOWN:
			moveDown();
			break;
		case Constants.UP:
			moveUp();
			break;
		default:
			throw new RuntimeException("There are only 4 directions");
		}
		newRandomPlacedTile();
	}

	private void moveLeft() {
		for (int row = 0; row < size; row++) {// for each line
			if (isRowEmpty(row))
				continue;
			// look for the first tile
			for (int col = 0; col < size - 1; col++) {
				if (this.getBoard()[row][col] == null) {
					for (int k = col + 1; k < size; k++) {
						if (this.getBoard()[row][k] != null) {
							this.getBoard()[row][col] = this.getBoard()[row][k];
							this.getBoard()[row][k] = null;
							break;
						}
					}
				}
			}
		}
		mergeLeft();
	}

	private void mergeLeft() {
		for (int row = 0; row < size; row++) {
			if (isRowEmpty(row))
				continue;
			for (int col = 0; col < size - 1; col++) {
				if (this.getBoard()[row][col] == null)
					continue;
				if (this.getBoard()[row][col].equals(this.getBoard()[row][col + 1])) {
					this.getBoard()[row][col].absorb(this.getBoard()[row][col + 1]);
					for (int k = col + 1; k < size - 1; k++) {
						this.getBoard()[row][k] = this.getBoard()[row][k + 1];
						this.getBoard()[row][k + 1] = null;
					}
					this.getBoard()[row][size - 1] = null;
				}
			}
		}
	}

	private void moveRight() {
		for (int row = 0; row < size; row++) {// for each line
			if (isRowEmpty(row))
				continue;
			// look for the first tile
			for (int col = size - 1; col > 0; col--) {
				if (this.getBoard()[row][col] == null) {
					for (int k = col - 1; k >= 0; k--) {
						if (this.getBoard()[row][k] != null) {
							this.getBoard()[row][col] = this.getBoard()[row][k];
							this.getBoard()[row][k] = null;
							break;
						}
					}
				}
			}
		}
		mergeRight();
	}

	private void mergeRight() {
		for (int row = 0; row < size; row++) {
			if (isRowEmpty(row))
				continue;
			for (int col = size - 1; col > 0; col--) {
				if (this.getBoard()[row][col] == null)
					continue;
				if (this.getBoard()[row][col].equals(this.getBoard()[row][col - 1])) {
					this.getBoard()[row][col].absorb(this.getBoard()[row][col - 1]);
					for (int k = col - 1; k > 0; k--) {
						this.getBoard()[row][k] = this.getBoard()[row][k - 1];
						this.getBoard()[row][k - 1] = null;
					}
					this.getBoard()[row][0] = null;
				}
			}
		}
	}

	private void moveUp() {
		for (int col = 0; col < size; col++) {
			if (isColEmpty(col))
				continue;
			for (int row = 0; row < size - 1; row++) {
				if (this.getBoard()[row][col] == null) {
					for (int k = row + 1; k < size; k++) {
						if (this.getBoard()[k][col] != null) {
							this.getBoard()[row][col] = this.getBoard()[k][col];
							this.getBoard()[k][col] = null;
							break;
						}
					}
				}
			}
		}
		mergeUp();
	}

	private void mergeUp() {
		for (int row = 0; row < size - 1; row++) {
			if (isRowEmpty(row))
				return;
			for (int col = 0; col < size; col++) {
				if (this.getBoard()[row][col] == null)
					continue;
				if (this.getBoard()[row][col].equals(this.getBoard()[row + 1][col])) {
					this.getBoard()[row][col].absorb(this.getBoard()[row + 1][col]);
					for (int k = row + 1; k < size - 1; k++) {
						this.getBoard()[k][col] = this.getBoard()[k + 1][col];
						this.getBoard()[k + 1][col] = null;
					}
					this.getBoard()[size - 1][col] = null;
				}
			}
		}
	}

	private void moveDown() {
		for (int col = 0; col < size; col++) {
			if (isColEmpty(col))
				continue;
			for (int row = size - 1; row > 0; row--) {
				if (this.getBoard()[row][col] == null) {
					for (int k = row - 1; k >= 0; k--) {
						if (this.getBoard()[k][col] != null) {
							this.getBoard()[row][col] = this.getBoard()[k][col];
							this.getBoard()[k][col] = null;
							break;
						}
					}
				}
			}
		}
		mergeDown();
	}

	private void mergeDown() {
		for (int row = size - 1; row > 0; row--) {
			if (isRowEmpty(row))
				return;
			for (int col = 0; col < size; col++) {
				if (this.getBoard()[row][col] == null)
					continue;
				if (this.getBoard()[row][col].equals(this.getBoard()[row - 1][col])) {
					this.getBoard()[row][col].absorb(this.getBoard()[row - 1][col]);
					for (int k = row - 1; k > 0; k--) {
						this.getBoard()[k][col] = this.getBoard()[k - 1][col];
						this.getBoard()[k - 1][col] = null;
					}
					this.getBoard()[0][col] = null;
				}
			}
		}

	}

	private void newRandomPlacedTile() {
		Random r = new Random();
		int x, y;
		do {
			x = r.nextInt(size);
			y = r.nextInt(size);
		} while (this.getBoard()[x][y] != null);
		this.getBoard()[x][y] = new Tile();
	}

	public boolean canMoveLeft() {
		for (int i = 0; i < 4; i++) {
			if (isRowEmpty(i))
				continue;
			if (this.getBoard()[i][0] == null)
				return true;
		}
		return canMergeHorizontally();
	}

	public boolean canMoveRight() {
		for (int i = 0; i < 4; i++) {
			if (isRowEmpty(i))
				continue;
			if (this.getBoard()[i][size - 1] == null)
				return true;
		}
		return canMergeHorizontally();
	}

	private boolean canMergeHorizontally() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size - 1; col++) {
				int k = col + 1;
				if (this.getBoard()[row][col] == null)
					continue;
				while (k < size - 1 && this.getBoard()[row][k] == null) {
					k++;
				}
				if (this.getBoard()[row][col].equals(getBoard()[row][k]))
					return true;
			}
		}
		return false;
	}

	public boolean canMoveUp() {
		for (int i = 0; i < 4; i++) {
			if (isColEmpty(i))
				continue;
			if (this.getBoard()[0][i] == null)
				return true;
		}
		return canMergeVertically();
	}

	public boolean canMoveDown() {
		for (int i = 0; i < 4; i++) {
			if (isColEmpty(i))
				continue;
			if (this.getBoard()[i][size - 1] == null)
				return true;
		}
		return canMergeVertically();
	}

	private boolean canMergeVertically() {
		for (int row = 0; row < size - 1; row++) {
			for (int col = 0; col < size; col++) {
				if (this.getBoard()[row][col] == null)
					continue;
				int k = row + 1;
				while (k < size - 1 && this.getBoard()[k][col] == null) {
					k++;
				}
				if (this.getBoard()[row][col].equals(getBoard()[k][col]))
					return true;
			}
		}
		return false;
	}

	private boolean isRowEmpty(int row) {
		if (row >= size) {
			throw new RuntimeException("There are only " + size + " lines");
		}
		for (int i = 0; i < size; i++) {
			if (this.getBoard()[row][i] != null)
				return false;
		}
		return true;
	}

	private boolean isColEmpty(int col) {
		if (col >= size) {
			throw new RuntimeException("There are only " + size + " lines");
		}
		for (int i = 0; i < size; i++) {
			if (this.getBoard()[i][col] != null)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				result += this.getBoard()[row][col] == null ? "_"
						: this.getBoard()[row][col];
				result += " ";
			}
			result += "\n";
		}
		return result;
	}

	public Tile[][] getBoard() {
		return board;
	}

	public void setBoard(Tile[][] board) {
		this.board = board;
	}
}

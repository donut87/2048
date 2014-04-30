package core;

public class Tile {

	public Tile() {
		this.value = 2;
	}

	public Tile(Tile t1, Tile t2) {
		if (t1.getValue() != t2.getValue()) {
			throw new RuntimeException(
					"Only tiles with same value can be merged");
		}
		this.value = t1.getValue() + t2.getValue();
	}

	private int value;

	public int getValue() {
		return value;
	}

	public void absorb(Tile t2) {
		this.value += t2.getValue();
	}

	public static Tile merge(Tile t1, Tile t2) {
		return new Tile(t1, t2);
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!obj.getClass().equals(this.getClass()))
			return false;
		return this.value == ((Tile) obj).getValue();
	}

}

package CodeSamples;

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PositionComparable implements Comparable<PositionComparable> {
	int x;
	int y;

	public PositionComparable(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(PositionComparable o) {
		if (x > o.x) {
			return 1;
		}
		else if (x < o.x) {
			return -1;
		}
		else {
			return y - o.y;
		}

	}
}

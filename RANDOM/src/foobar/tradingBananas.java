package foobar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

class GraphNoRepeatNode {
	private ArrayList<LinkedList<Integer>> possPairs;
	private boolean[] occupiedPos;
	private int numOccupiedPos;
	private int size;

	public GraphNoRepeatNode(int size) {
		possPairs = new ArrayList<>(size);
		occupiedPos = new boolean[size];
		numOccupiedPos = 0;
		this.size = size;
		for (int i = 0; i < size; i++) {
			possPairs.add(new LinkedList<Integer>());
		}
	}

	public LinkedList<Integer> getPossPairs(int pos) {
		return possPairs.get(pos);
	}

	public void addGuard(int pos, int pair) {
		possPairs.get(pos).add(pair);
	}

	public void visitPos(int pos) {
		occupiedPos[pos] = true;
		numOccupiedPos++;
	}

	public void revertVisitedPos(int pos) {
		occupiedPos[pos] = false;
		numOccupiedPos--;
	}

	public boolean[] getOccupiedPos() {
		return occupiedPos;
	}

	public int getSize() {
		return size;
	}

	public int getNumOccupied() {
		return numOccupiedPos;
	}

}

public class tradingBananas {

	public static void main(String[] args) {
		int[] bananaList = { 4, 8 };

		System.out.println(answer(bananaList));

	}

	public static int answer(int[] bananaList) {

		// add all possible pairings
		GraphNoRepeatNode possGuardPairs = new GraphNoRepeatNode(bananaList.length);
		for (int i = 0; i < bananaList.length; i++) {
			for (int j = i + 1; j < bananaList.length; j++) {
				if (isLoop(bananaList[i], bananaList[j])) {
					possGuardPairs.addGuard(i, j);
				}
			}
		}

		return bananaList.length - maxCountPairs(possGuardPairs, 0) * 2;
	}

	private static boolean isLoop(int n, int m) {
		int sum = n + m;
		double ckSumPow2 = Math.log(sum) / Math.log(2);
		if (n == m) {
			return false;
		}
		// if sum is odd or is multiple of 2 and not 4
		if (sum % 4 != 0) {
			return true;
		}
		// if sum is power of 2 then no loop
		if (Math.floor(ckSumPow2) == Math.ceil(ckSumPow2)) {
			return false;
		}

		// simulate loop
		HashSet<String> loopTracker = new HashSet<>();
		while (n != m) {
			String key = n + "," + m;
			String keyreverse = m + "," + n;
			double half = sum / 2;
			int less = Math.min(n, m);
			double ckDivPow2 = Math.log(half / less) / Math.log(2);

			// if less banana pile times a power of 2 is half then no loop
			if (Math.floor(ckDivPow2) == Math.ceil(ckDivPow2)) {
				return false;
			}
			// if you have gotten here before then loops
			if (loopTracker.contains(key) || loopTracker.contains(keyreverse)) {
				return true;
			}
			loopTracker.add(key);
			// who wins
			if (n > m) {
				n = n - m;
				m = m * 2;
			}
			else {
				m = m - n;
				n = n * 2;
			}
		}

		return false;
	}

	private static int maxCountPairs(GraphNoRepeatNode possGuardPairs, int startPos) {
		if (possGuardPairs.getNumOccupied() + 1 >= possGuardPairs.getSize()) {
			return 0;
		}

		int max = 0;
		boolean[] occupiedPos = possGuardPairs.getOccupiedPos();
		for (int i = startPos; i < occupiedPos.length; i++) {
			if (!occupiedPos[i]) {
				possGuardPairs.visitPos(i);
				for (Integer pairPos : possGuardPairs.getPossPairs(i)) {
					if (!occupiedPos[pairPos]) {
						possGuardPairs.visitPos(pairPos);
						max = Math.max(max, maxCountPairs(possGuardPairs, i + 1) + 1);
						possGuardPairs.revertVisitedPos(pairPos);
					}
				}
			}
		}
		return max;
	}
}

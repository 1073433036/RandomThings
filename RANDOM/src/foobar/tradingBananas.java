package foobar;

import java.util.ArrayList;
import java.util.Arrays;
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
		int[] bananaList = { 1, 7, 13, 21, 3, 19 };

		System.out.println(answer(bananaList));

	}

	public static int answer(int[] bananaList) {
		// sorting works
		Arrays.sort(bananaList);

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
		int gcd = gcd(n, m);
		double sumDivGcd = Math.log(n / gcd + m / gcd) / Math.log(2);
		boolean divlcmPow2 = Math.floor(sumDivGcd) == Math.ceil(sumDivGcd);

		// sum of (the numbers divided by their gcd) is not a power of 2
		// somehow this works
		return !divlcmPow2;
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static int maxCountPairs(GraphNoRepeatNode possGuardPairs, int startPos) {
		if (possGuardPairs.getNumOccupied() + 1 >= possGuardPairs.getSize()) {
			return 0;
		}

		// dfs graph w/o repeating nodes
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

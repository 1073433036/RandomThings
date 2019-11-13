
//package usacoFinished;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Three_Lines_2012USOpenBronze2 {
	static TreeMap<Integer, ArrayList<Integer>> xtoy = new TreeMap<>();
	static TreeMap<Integer, ArrayList<Integer>> ytox = new TreeMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPoints = scan.nextInt();
		for (int i = 0; i < numPoints; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (!xtoy.containsKey(x)) {
				xtoy.put(x, new ArrayList<Integer>());
			}
			xtoy.get(x).add(y);
			if (!ytox.containsKey(y)) {
				ytox.put(y, new ArrayList<Integer>());
			}
			ytox.get(y).add(x);
		}

		System.out.println(solve() ? 1 : 0);
		scan.close();
	}

	public static boolean solve() {
		// 3x
		if (xtoy.size() <= 3) {
			return true;
		}
		// 3y
		if (ytox.size() <= 3) {
			return true;
		}
		// 1x
		for (int xval : xtoy.keySet()) {
			int lines = 1 + ytox.size();
			for (int i = 0; i < xtoy.get(xval).size(); i++) {
				if (ytox.get(xtoy.get(xval).get(i)).size() <= 1) {
					lines--;
				}
			}
			if (lines <= 3) {
				return true;
			}
		}
		// 1y
		for (int yval : ytox.keySet()) {
			int lines = 1 + xtoy.size();
			for (int i = 0; i < ytox.get(yval).size(); i++) {
				if (xtoy.get(ytox.get(yval).get(i)).size() <= 1) {
					lines--;
				}
			}
			if (lines <= 3) {
				return true;
			}
		}

		return false;
	}
}

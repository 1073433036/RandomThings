package scam;

import java.util.HashMap;
import java.util.Scanner;

public class stairs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(climbUpStairs(n));
		scan.close();
	}

	static HashMap<Integer, Integer> solved = new HashMap<>();

	public static int climbUpStairs(int n) {
		solved.put(0, 1);
		solved.put(1, 1);
		return dfs(n);
	}

	public static int dfs(int n) {
		if (solved.containsKey(n)) {
			return solved.get(n);
		}

		int res = climbUpStairs(n - 2) + climbUpStairs(n - 1);

		solved.put(n, res);
		return res;
	}
}

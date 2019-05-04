
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class shell {
	static int[] start;
	static int[] end;
	static int[] guess;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("shell.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int moves = Integer.parseInt(st.nextToken());
		start = new int[moves];
		end = new int[moves];
		guess = new int[moves];

		for (int i = 0; i < moves; i++) {
			st = new StringTokenizer(f.readLine());
			start[i] = Integer.parseInt(st.nextToken()) - 1;
			end[i] = Integer.parseInt(st.nextToken()) - 1;
			guess[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		out.println(Math.max(solve(0), Math.max(solve(1), solve(2))));
		out.close();
		f.close();
	}

	public static int solve(int loc) {
		boolean[] shells = new boolean[3];
		shells[loc] = true;
		int count = 0;
		for (int i = 0; i < guess.length; i++) {
			boolean temp = shells[start[i]];
			shells[start[i]] = shells[end[i]];
			shells[end[i]] = temp;
			if (shells[guess[i]]) {
				count++;
			}
		}

		return count;
	}
}

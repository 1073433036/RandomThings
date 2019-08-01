/*
ID: juskim81
LANG: JAVA
TASK: barn1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int maxBoards = Integer.parseInt(st.nextToken());
		int numStalls = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		int[] occupied = new int[numCows];
		int min = numStalls;
		int max = 0;
		for (int i = 0; i < numCows; i++) {
			st = new StringTokenizer(f.readLine());
			occupied[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, occupied[i]);
			max = Math.max(max, occupied[i]);
		}
		for (int i = 0; i < numCows; i++) {
			occupied[i] -= min;
		}
		max -= min;
		Arrays.sort(occupied);

		int stallsUsed = max + 1;
		boolean[] removedBoard = new boolean[numCows];
		for (int boards = 1; boards < maxBoards; boards++) {
			int maxInd = -1;
			for (int i = 1; i < numCows; i++) {
				if (!removedBoard[i]
						&& (maxInd == -1 || occupied[i] - occupied[i - 1] > occupied[maxInd] - occupied[maxInd - 1])) {
					maxInd = i;
				}
			}
			if (maxInd == -1) {
				break;
			}

			removedBoard[maxInd] = true;
			stallsUsed -= occupied[maxInd] - occupied[maxInd - 1] - 1;
		}

		out.println(stallsUsed);
		out.close();
		f.close();
	}

}

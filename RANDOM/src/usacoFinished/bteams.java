
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class bteams {
	static int[] teampick = new int[12];
	static int[] teamcount = new int[4];
	static int answer = 0x3f3f3f3f;
	static int[] cows = new int[12];

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bteams.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bteams.out")));
		StringTokenizer st;

		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}
		minDiffTeam(0);

		out.println(answer);
		out.close();
		f.close();
	}

	public static void minDiffTeam(int player) {
		if (player == 12) {
			int[] teams = { 0, 0, 0, 0 };
			for (int i = 0; i < 12; i++) {
				teams[teampick[i]] += cows[i];
			}
			int min = Math.min(teams[0], Math.min(teams[1], Math.min(teams[2], teams[3])));
			int max = Math.max(teams[0], Math.max(teams[1], Math.max(teams[2], teams[3])));
			answer = Math.min(answer, max - min);
		}
		else {
			for (int i = 0; i < 4; i++) {
				if (teamcount[i] < 3) {
					teampick[player] = i;
					teamcount[i]++;
					minDiffTeam(player + 1);
					teamcount[i]--;
				}
			}
		}
	}
}

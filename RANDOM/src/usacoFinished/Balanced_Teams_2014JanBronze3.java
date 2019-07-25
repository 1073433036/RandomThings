
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Balanced_Teams_2014JanBronze3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bteams.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bteams.out")));
		StringTokenizer st;

		int[] cows = new int[12];
		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}
		int numAllCombos = (int) Math.pow(2, 24) - 1;
		int min = 0x3f3f3f3f;
		for (int i = 0; i < numAllCombos; i++) {
			int[] numOnTeam = new int[4];
			int[] skills = new int[4];
			boolean wrongTeam = false;
			int teamMax = 0;
			int teamMin = 0x3f3f3f3f;
			for (int j = 0; j < 12; j++) {
				int teamNum = (i >> 2 * (12 - j)) & 3;
				numOnTeam[teamNum]++;
				if (numOnTeam[teamNum] > 3) {
					wrongTeam = true;
					break;
				}
				skills[teamNum] += cows[j];
			}
			for (int j = 0; j < 4; j++) {
				teamMax = Math.max(teamMax, skills[j]);
				teamMin = Math.min(teamMin, skills[j]);
			}
			if (!wrongTeam) {
				min = Math.min(min, teamMax - teamMin);
			}
		}

		out.println(min);
		out.close();
		f.close();
	}
}

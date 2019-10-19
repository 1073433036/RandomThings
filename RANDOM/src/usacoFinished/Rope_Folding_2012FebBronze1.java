
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class Rope_Folding_2012FebBronze1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("folding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("folding.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numKnots = Integer.parseInt(st.nextToken());

		int[] knotPos = new int[numKnots];
		for (int i = 0; i < numKnots; i++) {
			st = new StringTokenizer(f.readLine());
			knotPos[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(knotPos);

		int count = 0;
		for (int i = 0; i < numKnots - 1; i++) {
			// knot
			double pos = knotPos[i];
			int left = i - 1;
			int right = i + 1;
			boolean works = true;
			while (0 <= left && right < numKnots) {
				if (pos - knotPos[left] != knotPos[right] - pos) {
					works = false;
				}
				left--;
				right++;
			}

			if (works) {
				count++;
			}

			left = i;
			right = i + 1;
			pos = (knotPos[left] + knotPos[right]) / 2.0;
			works = true;
			while (0 <= left && right < numKnots) {
				if (pos - knotPos[left] != knotPos[right] - pos) {
					works = false;
				}
				left--;
				right++;
			}

			if (works) {
				count++;
			}
		}

		out.println(count - 1);
		out.close();
		f.close();
	}
}

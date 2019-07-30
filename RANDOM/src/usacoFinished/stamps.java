
/*
ID: juskim81
LANG: JAVA
TASK: stamps
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.io.IOException;

public class stamps {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int maxStamps = Integer.parseInt(st.nextToken());
		int numStamps = Integer.parseInt(st.nextToken());
		int[] stamps = new int[numStamps + 1];
		for (int i = 1; i <= numStamps; i++) {
			stamps[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<int[]> stampSums = new ArrayList<>();
		// stampsums.get(i)[j]= using first j stamps min stamps to make value i
		// stampsums.get(i)[j]= min( stampsums.get(i)[j-1],
		// stampsums.get(i-vali)[j])
		int maxStampsUsed = 0;
		int max = 1;
		stampSums.add(new int[numStamps + 1]);
		while (maxStampsUsed <= maxStamps) {
			stampSums.add(new int[numStamps + 1]);
			stampSums.get(max)[0] = Integer.MAX_VALUE;
			for (int i = 1; i <= numStamps; i++) {
				if (max - stamps[i] < 0) {
					stampSums.get(max)[i] = stampSums.get(max)[i - 1];
					continue;
				}
				stampSums.get(max)[i] = Math.min(stampSums.get(max)[i - 1], stampSums.get(max - stamps[i])[i] + 1);
			}
			maxStampsUsed = Math.max(maxStampsUsed, stampSums.get(max)[numStamps]);
			max++;
		}

		out.println(max - 2);
		f.close();
		out.close();
	}
}

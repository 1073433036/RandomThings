package usaco;
/*
 * ID: juskim81
 * LANG: JAVA
 * TASK: rockers
 */

// import java.util.StringTokenizer;
// import java.io.BufferedReader;
// import java.io.PrintWriter;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;

import java.io.IOException;

public class rockers {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("rockers.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numSongs = Integer.parseInt(st.nextToken());
		int maxTime = Integer.parseInt(st.nextToken());
		int numDiscs = Integer.parseInt(st.nextToken());

		int[] songTimes = new int[numSongs];
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < numSongs; i++) {
			songTimes[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < (1 << numSongs); i++) {
			int curDisk = 1;
			int curTime = maxTime;
			int count = 0;
			for (int j = 0; j < numSongs; j++) {
				if(curDisk>numDiscs) {
					break;
				}
				if ((i & (1 << j)) != 0) {
					count++;
					if (songTimes[j] > maxTime) {
						count = -1;
						break;
					}
					if (songTimes[j] <= curTime) {
						curTime -= songTimes[j];
					}
					else {
						curDisk++;
						curTime = maxTime - songTimes[j];
					}
				}
			}
			if (curDisk <= numDiscs) {
				max = Math.max(max, count);
			}
		}

		out.println(max);
		out.close();
		f.close();
	}
}

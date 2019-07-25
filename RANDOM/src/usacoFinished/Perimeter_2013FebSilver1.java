
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.TreeSet;

public class Perimeter_2013FebSilver1 {
	static int[] ix = { 0, 0, -1, 1 };
	static int[] iy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numBales = Integer.parseInt(st.nextToken());
		int[] xs = new int[numBales];
		int[] ys = new int[numBales];
		int minx = 10000001;
		int miny = 10000001;
		for (int i = 0; i < numBales; i++) {
			st = new StringTokenizer(f.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
			minx = Math.min(minx, xs[i]);
			miny = Math.min(miny, ys[i]);
		}

		TreeSet<Long> bales = new TreeSet<>();
		int maxyWithx = 0;
		for (int i = 0; i < numBales; i++) {
			bales.add((xs[i] - minx + 2) * 10000000l + (ys[i] - miny + 2));
			if (xs[i] == minx && ys[i] - miny + 2 > maxyWithx) {
				maxyWithx = ys[i] - miny + 2;
			}
		}

		Long startPos = 20000000 + maxyWithx + 1l;
		int perimeter = 0;
		TreeSet<Long> perimVisited = new TreeSet<>();
		LinkedList<Long> currPos = new LinkedList<>();
		currPos.add(startPos);

		while (!currPos.isEmpty()) {
			Long pos = currPos.poll();
			if (perimVisited.contains(pos)) {
				continue;
			}
			perimVisited.add(pos);
			long x = pos / 10000000;
			long y = pos % 10000000;
			for (int k = 0; k < 4; k++) {
				long npos = (x + ix[k]) * 10000000 + y + iy[k];
				if (bales.contains(npos)) {
					perimeter++;
				}
				else if (!perimVisited.contains(npos)) {
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							if (bales.contains(npos + i * 10000000 + j)) {
								currPos.add(npos);
								i = 2;
								j = 2;
							}
						}
					}
				}
			}
		}

		out.println(perimeter);
		out.close();
		f.close();
	}
}


/*
ID: juskim81
LANG: JAVA
TASK: combo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.HashSet;

public class combo {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int dialNums = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());
		int fj1 = Integer.parseInt(st.nextToken()) % dialNums;
		int fj2 = Integer.parseInt(st.nextToken()) % dialNums;
		int fj3 = Integer.parseInt(st.nextToken()) % dialNums;

		st = new StringTokenizer(f.readLine());
		int ms1 = Integer.parseInt(st.nextToken()) % dialNums;
		int ms2 = Integer.parseInt(st.nextToken()) % dialNums;
		int ms3 = Integer.parseInt(st.nextToken()) % dialNums;

		// 0=dialnums
		HashSet<String> used = new HashSet<>();
		for (int d1c = -2; d1c <= 2; d1c++) {
			int d1 = (fj1 + d1c + dialNums) % dialNums;
			for (int d2c = -2; d2c <= 2; d2c++) {
				int d2 = (fj2 + d2c + dialNums) % dialNums;
				for (int d3c = -2; d3c <= 2; d3c++) {
					int d3 = (fj3 + d3c + dialNums) % dialNums;
					used.add(d1 + "" + d2 + "" + d3);
				}
			}
		}
		for (int d1c = -2; d1c <= 2; d1c++) {
			int d1 = (ms1 + d1c + dialNums) % dialNums;
			for (int d2c = -2; d2c <= 2; d2c++) {
				int d2 = (ms2 + d2c + dialNums) % dialNums;
				for (int d3c = -2; d3c <= 2; d3c++) {
					int d3 = (ms3 + d3c + dialNums) % dialNums;
					used.add(d1 + "" + d2 + "" + d3);
				}
			}
		}

		out.println(used.size());

		out.close();
		f.close();
	}

}

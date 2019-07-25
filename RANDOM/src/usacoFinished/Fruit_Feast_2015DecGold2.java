
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Fruit_Feast_2015DecGold2 {
	public static int answer(int a, int b, int f) {
		boolean[] arr = new boolean[f + 1];
		boolean[] arr2 = new boolean[f + 1];
		arr[0] = true;
		for (int i = 0; i <= f; i++)
			if (arr[i]) {
				if (i + a <= f)
					arr[i + a] = true;
				if (i + b <= f)
					arr[i + b] = true;
				arr2[i / 2] = true;
			}
		int ans = 0;
		for (int i = 0; i <= f; i++)
			if (arr2[i]) {
				if (i + a <= f)
					arr2[i + a] = true;
				if (i + b <= f)
					arr2[i + b] = true;
				ans = i;
			}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("feast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int fullness = Integer.parseInt(st.nextToken());
		int orangeFill = Integer.parseInt(st.nextToken());
		int lemonFill = Integer.parseInt(st.nextToken());

		out.println(answer(orangeFill, lemonFill, fullness));
		out.close();
		f.close();
	}
}

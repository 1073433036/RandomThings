
//package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Haybale_Stacking_2012JanBronze2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("stacking.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int size = Integer.parseInt(st.nextToken());
		int instructions = Integer.parseInt(st.nextToken());
		int[] stacks = new int[size + 1];
		for (int i = 0; i < instructions; i++) {
			st = new StringTokenizer(f.readLine());
			stacks[Integer.parseInt(st.nextToken())]++;
			stacks[Integer.parseInt(st.nextToken()) + 1]--;
		}

		for (int i = 0; i < stacks.length; i++) {
			stacks[i] += stacks[i - 1];
		}

		Arrays.sort(stacks);

		out.println(stacks[size / 2]);
		out.close();
		f.close();
	}
}

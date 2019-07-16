
// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class maxcross {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lightNum = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int damaged = Integer.parseInt(st.nextToken());
		boolean[] lights = new boolean[lightNum];
		for (int i = 0; i < damaged; i++) {
			st = new StringTokenizer(f.readLine());
			lights[Integer.parseInt(st.nextToken()) - 1] = true;
		}
		int slider = 0;
		for (int i = 0; i < row; i++)
			if (!lights[i])
				slider++;

		int min = row - slider;
		for (int i = row; i < lightNum; i++) {
			if (!lights[i - row])
				slider--;
			if (!lights[i])
				slider++;
			min = Math.min(min, row - slider);
		}
		out.println(min);
		out.close();
		f.close();
	}
}


// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class tilechng {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("tilechng.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tilechng.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int tilenum = Integer.parseInt(st.nextToken()), size = Integer.parseInt(st.nextToken());
		int[] tiles = new int[tilenum + 1];
		for (int i = 1; i <= tilenum; i++) {
			st = new StringTokenizer(f.readLine());
			tiles[i] = Integer.parseInt(st.nextToken());
		}

		int[][] tileposs = new int[size + 1][tilenum + 1];
		for (int i = 1; i <= size; i++)// init for prevsolved
			tileposs[i][0] = 100000000;

		for (int j = 1; j <= tilenum; j++)
			for (int i = 0; i <= size; i++) {
				tileposs[i][j] = 100000000;// current
				for (int k = 1; k * k <= i; k++)// check+prevsolved<current
					if ((tiles[j] - k) * (tiles[j] - k) + tileposs[i - k * k][j - 1] < tileposs[i][j])
						tileposs[i][j] = (tiles[j] - k) * (tiles[j] - k) + tileposs[i - k * k][j - 1];
			}// set to check+prevsolved

		if (tileposs[size][tilenum] == 100000000)// final number not correct
			out.println(-1);
		else
			out.println(tileposs[size][tilenum]);

		out.close();
		f.close();
	}
}

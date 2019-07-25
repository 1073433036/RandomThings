
// package usacoFinished;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.PriorityQueue;

public class Distant_Pastures_2012NovSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("distant.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("distant.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		int samecost = Integer.parseInt(st.nextToken());
		int diffcost = Integer.parseInt(st.nextToken());
		boolean[][] pastures = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			String line = f.readLine();
			for (int j = 0; j < size; j++) {
				pastures[i][j] = line.charAt(j) == '(';
			}
		}

		int[][][][] distances = new int[size][size][size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						distances[i][j][k][l] = Integer.MAX_VALUE;
						if (i == k && j == l) {
							distances[i][j][k][l] = 0;
						}
					}
				}
			}
		}

		int[] chi = { 0, 0, 1, -1 };
		int[] chj = { 1, -1, 0, 0 };
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boolean[][] visited = new boolean[size][size];
				PriorityQueue<Node> q = new PriorityQueue<>();
				q.add(new Node(i, j, 0));
				while (!q.isEmpty()) {
					int curi = q.peek().x;
					int curj = q.poll().y;
					if (visited[curi][curj]) {
						continue;
					}
					visited[curi][curj] = true;
					for (int k = 0; k < 4; k++) {
						if (curi + chi[k] >= 0 && curi + chi[k] < size && curj + chj[k] >= 0 && curj + chj[k] < size) {
							int cost = pastures[curi][curj] == pastures[curi + chi[k]][curj + chj[k]] ? samecost
									: diffcost;
							if (distances[i][j][curi + chi[k]][curj + chj[k]] > distances[i][j][curi][curj] + cost) {
								distances[i][j][curi + chi[k]][curj + chj[k]] = distances[i][j][curi][curj] + cost;
								q.add(new Node(curi + chi[k], curj + chj[k],
										distances[i][j][curi + chi[k]][curj + chj[k]]));

							}
						}
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						if (distances[i][j][k][l] != Integer.MAX_VALUE && !(i == k && j == l)) {
							max = Math.max(max, distances[i][j][k][l]);
						}
					}
				}
			}
		}

		out.println(max);
		f.close();
		out.close();
	}

	private static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
}

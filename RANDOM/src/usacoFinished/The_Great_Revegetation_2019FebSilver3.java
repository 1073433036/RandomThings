
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class The_Great_Revegetation_2019FebSilver3 {
	private static class pair {
		int dest;
		boolean same;

		public pair(int d, boolean s) {
			dest = d;
			same = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numFields = Integer.parseInt(st.nextToken());
		int numConnections = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<pair>> connections = new ArrayList<>(numFields);
		for (int i = 0; i < numFields; i++) {
			connections.add(new ArrayList<pair>());
		}

		for (int i = 0; i < numConnections; i++) {
			st = new StringTokenizer(f.readLine());
			boolean same = st.nextToken().equals("S");
			int src = Integer.parseInt(st.nextToken()) - 1;
			int dest = Integer.parseInt(st.nextToken()) - 1;
			connections.get(src).add(new pair(dest, same));
			connections.get(dest).add(new pair(src, same));
		}

		String result = "";
		LinkedList<pair> left = new LinkedList<>();
		byte[] visited = new byte[numFields];
		for (int i = 0; i < numFields; i++) {
			if (visited[i] != 0) {
				continue;
			}
			if (connections.get(i).size() == 0) {
				result += "0";
				visited[i] = 3;
				continue;
			}
			left.add(new pair(i, true));
			while (!left.isEmpty()) {
				int pos = left.peek().dest;
				boolean color = left.poll().same;
				if (visited[pos] != 0) {
					continue;
				}
				visited[pos] = (byte) (color ? 1 : 2);
				for (int j = 0; j < connections.get(pos).size(); j++) {
					int dest = connections.get(pos).get(j).dest;
					boolean same = connections.get(pos).get(j).same;
					if (visited[dest] != 0) {
						if (!((same && visited[pos] == visited[dest]) || (!same && visited[pos] != visited[dest]))) {
							// impossible
							out.println(0);
							out.close();
							f.close();
							return;
						}
					}
					else {
						left.add(new pair(dest, same ? color : !color));
					}
				}
			}
			result += "0";
		}

		out.println("1" + result);
		out.close();
		f.close();
	}
}

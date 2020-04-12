package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KargerMinCut {

	public static void main(String[] args) throws IOException {
		int min = 200000;
		for (int times = 0; times < 200; times++) {
			BufferedReader f = new BufferedReader(new FileReader("adjlist.txt"));
			StringTokenizer st;
			HashMap<Integer, HashMap<Integer, Integer>> adjlist = new HashMap<>();
			for (int i = 0; i < 200; i++) {
				st = new StringTokenizer(f.readLine());
				st.nextToken();
				HashMap<Integer, Integer> adj = new HashMap<>();
				while (st.hasMoreTokens()) {
					int dest = Integer.parseInt(st.nextToken());
					if (adj.containsKey(dest)) {
						adj.put(dest, adj.get(dest) + 1);
					}
					else {
						adj.put(dest, 1);
					}
				}
				adjlist.put(i + 1, adj);
			}
			f.close();

			while (adjlist.size() > 2) {
				int size = 0;
				for (int s : adjlist.keySet()) {
					for (int d : adjlist.get(s).keySet()) {
						size += adjlist.get(s).get(d);
					}
				}

				int choice = (int) (Math.random() * size + 1);
				int src = 0;
				int dest = 0;
				int count = 0;
				for (int s : adjlist.keySet()) {
					for (int d : adjlist.get(s).keySet()) {
						count += adjlist.get(s).get(d);
						if (count >= choice) {
							src = s;
							dest = d;
							break;
						}
					}
					if (src != 0) {
						break;
					}
				}

				// System.out.println(adjlist + " " + src + " " + dest + " " +
				// choice+" "+size);
				HashMap<Integer, Integer> nadj = adjlist.get(src);
				for (int dd : adjlist.get(dest).keySet()) {
					if (dd == src) {
						continue;
					}
					int c = adjlist.get(dest).get(dd);
					if (nadj.containsKey(dd)) {
						nadj.put(dd, nadj.get(dd) + c);
					}
					else {
						nadj.put(dd, c);
					}
					c = adjlist.get(dd).get(dest);
					if (adjlist.get(dd).containsKey(src)) {
						adjlist.get(dd).put(src, adjlist.get(dd).get(src) + c);
					}
					else {
						adjlist.get(dd).put(src, c);
					}
					adjlist.get(dd).remove(dest);
				}
				if (nadj.containsKey(dest)) {
					nadj.remove(dest);
				}
				if (nadj.containsKey(src)) {
					nadj.remove(src);
				}
				adjlist.remove(dest);
				adjlist.put(src, nadj);

				// System.out.println(adjlist);
			}

			min = Math.min(min,
					adjlist.entrySet().iterator().next().getValue().entrySet().iterator().next().getValue());

			// System.out.println(min);
		}
		System.out.println(min);

	}
}

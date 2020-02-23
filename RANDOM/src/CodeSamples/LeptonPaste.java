package CodeSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeptonPaste {
	private static class old {
		// vim: syntax=java
		/*
		 * Find the shortest path from a node to all other nodes by finding the
		 * node
		 * with the minimum distance and updating nodes connected the minimum
		 * node
		 * Doesn't work for graphs with negative weights, use Bellman-Ford
		 *
		 * O(V^2) for dense graphs
		 * 
		 * O((E+V)logV) for sparse graphs
		 */

		private static int numNodes;
		private static ArrayList<ArrayList<edge>> connections;

		private static class edge {
			int dest;
			int weight;

			public edge(int dest, int weight) {
				this.dest = dest;
				this.weight = weight;
			}
		}

		public static int[] densedijkstra(int src) {
			boolean[] visited = new boolean[numNodes];
			int[] distances = new int[numNodes];
			for (int i = 0; i < numNodes; i++) {
				distances[i] = Integer.MAX_VALUE;
			}

			distances[src] = 0;
			for (int i = 0; i < numNodes; i++) {
				int minind = -1;
				for (int j = 0; j < numNodes; j++) {
					if (!visited[j] && (minind == -1 || distances[j] < distances[minind])) {
						minind = j;
					}
				}

				visited[minind] = true;
				for (edge conn : connections.get(minind)) {
					if (!visited[conn.dest]) {
						distances[conn.dest] = Math.min(distances[conn.dest], conn.weight + distances[minind]);
					}
				}
			}

			return distances;
		}

		private static class pair implements Comparable<pair> {
			int id;
			int dist;

			public pair(int id, int dist) {
				this.id = id;
				this.dist = dist;
			}

			public int compareTo(pair o) {
				return this.dist - o.dist;
			}
		}

		public static int[] sparsedijkstra(int src) {
			int[] distances = new int[numNodes];
			boolean[] visited = new boolean[numNodes];
			for (int i = 0; i < numNodes; i++) {
				distances[i] = Integer.MAX_VALUE;
			}

			PriorityQueue<pair> nextNodes = new PriorityQueue<>();
			nextNodes.add(new pair(src, 0));
			distances[src] = 0;

			while (!nextNodes.isEmpty()) {
				int cur = nextNodes.peek().id;
				int cost = nextNodes.poll().dist;
				if (visited[cur]) {
					continue;
				}

				visited[cur] = true;
				for (edge conn : connections.get(cur)) {
					int ncost = conn.weight + cost;
					if (distances[conn.dest] > ncost) {
						distances[conn.dest] = ncost;
						nextNodes.add(new pair(conn.dest, distances[conn.dest]));
					}
				}
			}

			return distances;
		}

		private static class old1 {
			// vim: syntax=java
			/*
			 * Find the minimum spanning tree of a graph by finding the minimum
			 * of the
			 * non visited nodes and updating the weights of other vertices
			 * connected to
			 * the current node
			 * 
			 * O((V+E)logV) for sparse graphs
			 *
			 * O(V^2) for dense graphs
			 */

			private static int numNodes;
			private static ArrayList<ArrayList<edge>> connections;

			private static class edge {
				int dest;
				int weight;

				public edge(int dest, int weight) {
					this.dest = dest;
					this.weight = weight;
				}
			}

			public static int denseprim() {
				boolean[] visited = new boolean[numNodes];
				int[] distances = new int[numNodes];
				for (int i = 0; i < numNodes; i++) {
					distances[i] = Integer.MAX_VALUE;
				}

				distances[0] = 0;
				int cost = 0;
				for (int i = 0; i < numNodes; i++) {
					int minind = -1;
					for (int j = 0; j < numNodes; j++) {
						if (!visited[j] && (minind == -1 || distances[j] < distances[minind])) {
							minind = j;
						}
					}

					visited[minind] = true;
					cost += distances[minind];
					for (edge conn : connections.get(minind)) {
						if (!visited[conn.dest]) {
							distances[conn.dest] = Math.min(distances[conn.dest], conn.weight);
						}
					}
				}

				return cost;
			}

			private static class pair implements Comparable<pair> {
				int id;
				int dist;

				public pair(int id, int dist) {
					this.id = id;
					this.dist = dist;
				}

				public int compareTo(pair o) {
					return this.dist - o.dist;
				}
			}

			public static int sparseprim() {
				int[] distances = new int[numNodes];
				for (int i = 0; i < numNodes; i++) {
					distances[i] = Integer.MAX_VALUE;
				}

				PriorityQueue<pair> nextNodes = new PriorityQueue<>();
				nextNodes.add(new pair(0, 0));
				int totalcost = 0;
				while (!nextNodes.isEmpty()) {
					int cur = nextNodes.peek().id;
					int cost = nextNodes.poll().dist;
					if (distances[cur] != Integer.MAX_VALUE) {
						continue;
					}

					distances[cur] = cost;
					totalcost += cost;
					for (edge conn : connections.get(cur)) {
						if (distances[conn.dest] == Integer.MAX_VALUE) {
							nextNodes.add(new pair(conn.dest, conn.weight));
						}
					}
				}

				return totalcost;
			}

			private static class old2 {
				// vim: syntax=java
				/*
				 * Find the minimum spanning tree of a graph by adding the
				 * minimum edge
				 * weight if it doesn't form a cycle
				 * 
				 * O(ElogE)
				 */
				private static class edge implements Comparable<edge> {
					int src;
					int dest;
					int weight;

					public edge() {

					}

					public edge(int src, int dest, int weight) {
						this.src = src;
						this.dest = dest;
						this.weight = weight;
					}

					public int compareTo(edge other) {
						return this.weight - other.weight;
					}
				}

				private static class subset {
					int parent;
					int rank;

					public subset(int parent, int rank) {
						this.parent = parent;
						this.rank = rank;
					}
				}

				public static int find(subset[] subsets, int element) {
					if (subsets[element].parent != element) {
						subsets[element].parent = find(subsets, subsets[element].parent);
					}
					return subsets[element].parent;
				}

				public static void union(subset[] subsets, int x, int y) {
					int xroot = find(subsets, x);
					int yroot = find(subsets, y);

					if (subsets[xroot].rank < subsets[yroot].rank) {
						subsets[xroot].parent = yroot;
					}
					else if (subsets[xroot].rank > subsets[yroot].rank) {
						subsets[yroot].parent = xroot;
					}
					else {
						subsets[yroot].parent = xroot;
						subsets[xroot].rank++;
					}
				}

				private static int numNodes;
				private static edge[] edges;

				public static void kruskalmst() {
					edge[] result = new edge[numNodes];
					int resind = 0;
					int i = 0;
					for (i = 0; i < numNodes; i++) {
						result[i] = new edge();
					}

					Arrays.sort(edges);

					subset[] subsets = new subset[numNodes];
					for (i = 0; i < numNodes; i++) {
						subsets[i] = new subset(i, 0);
					}

					i = 0;
					while (resind < numNodes - 1) {
						edge next = edges[i++];

						int x = find(subsets, next.src);
						int y = find(subsets, next.dest);

						// forms a cycle when both are parts of the same subset
						if (x != y) {
							result[resind++] = next;
							union(subsets, x, y);
						}
					}
				}
				// vim: syntax=java
				/*
				 * Search a sorted array by determining if the target is higher
				 * or lower
				 * than the middle
				 * If there are multiple occurrences, it may find the index of
				 * any
				 * occurrence
				 * 
				 * O(logN)
				 */

				// Arrays.binarySearch(array, left, right, target, comparator);
				// This returns the index if found, or (-insertion point - 1) if
				// not found
				private static int[] array;

				public static int binarysearch(int target) {
					int index = -1;
					int left = 0;
					int right = array.length - 1;
					while (left <= right) {
						int mid = (left + right) / 2;
						if (array[mid] == target) {
							index = mid;
							break;
						}
						else if (array[mid] > target) {
							right = mid - 1;
						}
						else {
							left = mid + 1;
						}
					}

					return index;
				}

				private static class old3 {
					// vim: syntax=java
					/*
					 * Find the lca of two nodes in a tree by storing the 2^jth
					 * ancestors and
					 * finding the kth ancestor
					 * 
					 * O(VlogV)
					 */

					private static int numNodes;
					private static int[] parents;
					private static int[] level;
					private static int[][] ancestors;

					public static void preprocess() {
						for (int i = 0; i < numNodes; i++) {
							for (int j = 0; (1 << j) < numNodes; j++) {
								ancestors[i][j] = -1;
							}
						}

						for (int i = 0; i < numNodes; i++) {
							ancestors[i][0] = parents[i];
						}

						for (int j = 1; (1 << j) < numNodes; j++) {
							for (int i = 0; i < numNodes; i++) {
								if (ancestors[i][j - 1] != -1) {
									ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
								}
							}
						}
					}

					public static int lca(int x, int y) {
						if (level[x] < level[y]) {
							int temp = x;
							x = y;
							y = temp;
						}

						int dist = level[x] - level[y];
						while (dist > 0) {
							int raiseby = (int) (Math.round(Math.log(dist) / Math.log(2)));
							x = ancestors[x][raiseby];
							dist -= 1 << raiseby;
						}

						if (x == y) {
							return x;
						}

						for (int j = ancestors[0].length - 1; j >= 0; j--) {
							if ((ancestors[x][j] != -1) && (ancestors[x][j] != ancestors[y][j])) {
								x = ancestors[x][j];
								y = ancestors[y][j];
							}
						}

						return parents[x];
					}
				}
			}
		}
		// vim: syntax=java
		/*
		 * Finds the longest increasing subsequence by using dynamic programming
		 * lis[i]=length of maximum lis up to the ith element
		 * lis[i]=1+max(lis[j]) for j<i and array[j]<array[i]
		 * 
		 * O(N^2)
		 */

		private static int N;
		private static int[] array;

		public static int lis() {
			int[] lis = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (array[j] < array[i]) {
						lis[i] = Math.max(lis[i], lis[j] + 1);
					}
				}
				max = Math.max(max, lis[i]);
			}

			return max;
		}

		private static class old4 {
			// vim: syntax=java
			/*
			 * Finds the longest common subsequence of two arrays by using
			 * dynamic
			 * programming
			 * lcs[i][j]=length of largest common subsequence up to ith and jth
			 * elements
			 * lcs[i][j]=lcs[i-1][j-1] if a[i]==b[j], else
			 * max(lcs[i-1][j], lcs[i][j-1])
			 * 
			 * O(NM)
			 */

			private static int N;
			private static int M;
			private static int[] array1;
			private static int[] array2;

			public static int lcs() {
				int[][] lcs = new int[N + 1][M + 1];
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if (array1[i - 1] == array2[j - 1]) {
							lcs[i][j] = lcs[i - 1][j - 1] + 1;
						}
						else {
							lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
						}
					}
				}

				return lcs[N][M];
			}

			private static class old5 {
				// vim: syntax=java
				/*
				 * Finds the edit distance of two arrays by using dynamic
				 * programming
				 * ed[i][j]=edit distance for changing up to ith into up to jth
				 * ed[i][j]=ed[i-1][j-1] if a[i]==b[j], else
				 * min(ed[i-1][j], ed[i][j-1], ed[i-1][j-1])
				 * 
				 * O(NM)
				 */

				private static int N;
				private static int M;
				private static int[] array1;
				private static int[] array2;

				public static int editdistance() {
					int[][] ed = new int[N + 1][M + 1];

					for (int i = 0; i <= N; i++) {
						ed[i][0] = i;
					}
					for (int j = 0; j <= M; j++) {
						ed[0][j] = j;
					}

					for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= M; j++) {
							if (array1[i - 1] == array2[j - 1]) {
								ed[i][j] = ed[i - 1][j - 1];
							}
							else {
								ed[i][j] = Math.min(ed[i - 1][j - 1], Math.min(ed[i - 1][j], ed[i][j - 1])) + 1;
							}
						}
					}

					return ed[N][M];
				}
			}
			// vim: syntax=java
			/*
			 * Finds the shortest path from any node to any other node by
			 * getting the
			 * path for every intermediate node from every start node to every
			 * end node
			 * 
			 * O(V^3)
			 */

			private static int numNodes;
			private static int[][] connections;
			private static int[][] distances;

			public static void floydwarshall() {
				distances = new int[numNodes][numNodes];

				for (int i = 0; i < numNodes; i++) {
					for (int j = 0; j < numNodes; j++) {
						distances[i][j] = connections[i][j];
					}
				}

				for (int j = 0; j < numNodes; j++) {
					for (int i = 0; i < numNodes; i++) {
						for (int k = 0; k < numNodes; k++) {
							if (distances[i][j] != Integer.MAX_VALUE && distances[j][k] != Integer.MAX_VALUE) {
								distances[i][k] = Math.min(distances[i][k], distances[i][j] + distances[j][k]);
							}
						}
					}
				}
			}
		}
		// vim: syntax=java
		/*
		 * Finds the minimum number of coins with reusing required to make an
		 * amount
		 * c[i][j]=minimum number of coins required to make amount i with j
		 * coins
		 * c[i][j]=min(c[i][j-1], 1+c[i-coins[k]][j]) for k<=j
		 * 
		 * O(NK)
		 */

		private static int numCoins;
		private static int[] coins;

		public static int mincoins(int target) {
			int[][] c = new int[target + 1][numCoins + 1];

			for (int i = 1; i <= target; i++) {
				c[i][0] = Integer.MAX_VALUE;
			}

			for (int i = 1; i <= target; i++) {
				for (int j = 1; j <= numCoins; j++) {
					c[i][j] = c[i][j - 1];
					if (coins[j - 1] <= i) {
						int prev = c[i - coins[j - 1]][j];
						if (prev != Integer.MAX_VALUE) {
							c[i][j] = Math.min(c[i][j], 1 + prev);
						}
					}
				}
			}

			return c[target][numCoins];
		}

		public static class old5 {
			// vim: syntax=java
			/*
			 * Finds the shortest path from any node to all other nodes by
			 * finding the
			 * shortest paths from least amount of edges to greatest
			 * 
			 * O(VE)
			 */

			private static int numNodes;
			private static int numEdges;
			private static ArrayList<edge> edges;
			private static int[] distances;

			private static class edge {
				int src;
				int dest;
				int weight;

				public edge(int src, int dest, int weight) {
					this.src = src;
					this.dest = dest;
					this.weight = weight;
				}
			}

			public static void bellmanford(int src) {
				for (int i = 0; i < numNodes; i++) {
					distances[i] = Integer.MAX_VALUE;
				}

				distances[src] = 0;

				boolean changed = false;
				for (int i = 0; i < numNodes; i++) {
					changed = false;
					for (int j = 0; j < numEdges; j++) {
						int n1 = edges.get(j).src;
						int n2 = edges.get(j).dest;
						int weight = edges.get(j).weight;
						int cost = distances[n1] + weight;
						if (distances[n1] != Integer.MAX_VALUE && distances[n2] > cost) {
							distances[n2] = cost;
							changed = true;
						}
					}

					if (!changed) {
						break;
					}
				}

				if (changed) {
					System.out.println("negative weight cycle");
				}
			}
			// vim: syntax=java
			/*
			 * Finds if a point is inside or outside of a polygon by counting
			 * the number
			 * of intersections with all of the edges of the polygon
			 * 
			 * O(S)
			 */

			public static int numpoints;
			public static point[] polygon;

			private static class point {
				int x;
				int y;

				public point(int x, int y) {
					this.x = x;
					this.y = y;
				}
			}

			// p,q,r are colinear
			public static boolean onsegment(point p, point q, point r) {
				return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
						&& q.y >= Math.min(p.y, r.y);
			}

			// 0= colinear, 1= clockwise, -1= counterclockwise
			public static int orientation(point p, point q, point r) {
				return (int) Math.signum((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
			}

			public static boolean intersects(point p1, point p2, point q1, point q2) {
				int o1 = orientation(p1, p2, q1);
				int o2 = orientation(p1, p2, q2);
				int o3 = orientation(q1, q2, p1);
				int o4 = orientation(q1, q2, p2);

				if (o1 != o2 && o3 != o4) {
					return true;
				}

				return o1 == 0 && onsegment(p1, q1, p2) || o2 == 0 && onsegment(p1, q2, p2)
						|| o3 == 0 && onsegment(q1, p1, q2) || o4 == 0 && onsegment(q1, p2, q2);
			}

			public static boolean inside(point[] polygon, point p) {
				point extreme = new point(10000, p.y + 1);
				int count = 0;
				for (int i = 0; i < numpoints; i++) {
					int next = (i + 1) % numpoints;
					if (intersects(polygon[i], polygon[next], p, extreme)) {
						if (orientation(polygon[i], p, polygon[next]) == 0) {
							return onsegment(polygon[i], p, polygon[next]);
						}
						count++;
					}
				}

				return count % 2 == 1;
			}
		}
		// vim: syntax=java
		/*
		 * Finds if two line segments intersect by checking if the orientation
		 * between 2 pairs of 3 points differ
		 * o(p1, q1, p2) != o(p1, q1, q2) and o(p2, q2, p1) != o(p2, q2, q1)
		 * 
		 * O(1)
		 */

		private static class point {
			int x;
			int y;

			public point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		// p,q,r are colinear
		public static boolean onsegment(point p, point q, point r) {
			return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
					&& q.y >= Math.min(p.y, r.y);
		}

		// 0= colinear, 1= clockwise, -1= counterclockwise
		public static int orientation(point p, point q, point r) {
			return (int) Math.signum((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
		}

		public static boolean intersects(point p1, point p2, point q1, point q2) {
			int o1 = orientation(p1, q1, p2);
			int o2 = orientation(p1, q1, q2);
			int o3 = orientation(p2, q2, p1);
			int o4 = orientation(p2, q2, q1);

			if (o1 != o2 && o3 != o4) {
				return true;
			}

			return o1 == 0 && o2 == 0 && (onsegment(p1, p2, q1) || onsegment(p1, q2, q1));
		}

		public static class old6 {

			// vim: syntax=java
			/*
			 * Find an ordering of the graph such that for every edge, the
			 * source comes
			 * before the destination by removing nodes that have no indegree
			 * and
			 * updating the other values
			 *
			 * O(V+E)
			 */

			private static int numNodes;
			private static ArrayList<ArrayList<Integer>> connections;

			public static int[] topologicalsort() {
				int[] result = new int[numNodes];
				int[] indegrees = new int[numNodes];
				for (ArrayList<Integer> dests : connections) {
					for (Integer conn : dests) {
						indegrees[conn]++;
					}
				}

				LinkedList<Integer> nodesleft = new LinkedList<>();
				for (int i = 0; i < numNodes; i++) {
					if (indegrees[i] == 0) {
						nodesleft.add(i);
					}
				}

				int i = 0;
				while (!nodesleft.isEmpty()) {
					int cur = nodesleft.poll();

					result[i++] = cur;
					for (int conn : connections.get(cur)) {
						indegrees[conn]--;
						if (indegrees[conn] == 0) {
							nodesleft.add(conn);
						}
					}
				}

				return result;
			}
		}
	}

	
	
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		numNodes = 5;
//		int numConn = 8;
//		connections = new ArrayList<>();
//		for (int i = 0; i < numNodes; i++) {
//			connections.add(new ArrayList<edge>());
//		}
//
//		for (int i = 0; i < numConn; i++) {
//			int src = scan.nextInt();
//			int dest = scan.nextInt();
//			int weight = scan.nextInt();
//			connections.get(src).add(new edge(dest, weight));
//		}
//
//		System.out.println(Arrays.toString(sparsedijkstra(0)));
	}
}
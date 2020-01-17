package CodeSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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
	}

	// vim: syntax=java
	/*
	 * Finds the minimum number of coins with reusing required to make an amount
	 * c[i][j]=minimum number of coins required to make amount i with j coins
	 * c[i][j]=min(c[i][j-1], 1+c[i-coins[k]][j]) for k<=j
	 * 
	 * O(NK)
	 */

	public static void main(String[] args) {

	}
}
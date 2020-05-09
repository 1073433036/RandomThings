package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class clustering {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("clustering2.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numNodes = Integer.parseInt(st.nextToken());

		// int count = 0;
		// edges = new edge[500*499];
		// while (f.ready()) {
		// st = new StringTokenizer(f.readLine());
		// int src = Integer.parseInt(st.nextToken()) - 1;
		// int dest = Integer.parseInt(st.nextToken()) - 1;
		// int weight = Integer.parseInt(st.nextToken());
		// edges[count++] = new edge(src, dest, weight);
		// edges[count++] = new edge(dest, src, weight);
		// }
		// System.out.println(count);

		edges = new edge[717582];
		edgelist = new LinkedList<>();
		BigInteger[] nodes = new BigInteger[numNodes];
		for (int i = 0; i < numNodes; i++) {
			String n = f.readLine().replaceAll(" ", "");
			nodes[i] = new BigInteger(n, 2);
		}

		int a = 0;
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (i != j) {
					int w = nodes[i].xor(nodes[j]).bitCount();
					// edgelist.add(new edge(i, j, w));
					if (w < 3) {
						edges[a++] = new edge(i, j, w);
					}
				}
			}
		}
		System.out.println(a);

		kruskalmst();

		f.close();
	}

	// vim: syntax=java
	/*
	 * Find the minimum spanning tree of a graph by adding the minimum edge
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

		public String toString() {
			return "(" + src + "," + dest + ") " + weight;
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

	private static LinkedList<edge> edgelist;

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
		System.out.println(Arrays.toString(result));

	}
}

// 106

/*
 * import copy
 * import itertools
 * from collections import namedtuple
 * 
 * 
 * Edge = namedtuple('Edge', ('head', 'tail', 'cost'))
 * 
 * 
 * class UnionFind:
 * def __init__(self, nodes):
 * self.nodes = nodes
 * self.leaders = dict()
 * self.members = dict()
 * for node in nodes:
 * # Keeps mapping of leaders to groups
 * if str(node) not in self.leaders:
 * self.leaders[str(node)] = [node]
 * # Account for duplicate node ids
 * else:
 * self.leaders[str(node)].append(node)
 * # Keeps mapping of nodes to leaders
 * self.members[str(node)] = node
 * 
 * def find(self, node):
 * return self.members[str(node)]
 * 
 * def union(self, node1, node2):
 * # Find our two groups and decide which should be merged into which by
 * # size of group
 * (old_leader, new_leader) = sorted((self.find(node1), self.find(node2)),
 * key = lambda x:
 * len(self.leaders[str(x)]))
 * # If these two nodes were already in the same group we are finished
 * if old_leader == new_leader:
 * return
 * else:
 * # Add the old group the new group
 * old_group = self.leaders.pop(str(old_leader))
 * self.leaders[str(new_leader)].extend(old_group)
 * # Reassign the leaders in the old group
 * for node in old_group:
 * self.members[str(node)] = new_leader
 * 
 * def read_file(path):
 * """Read a file and return a list of edges"""
 * edges = list()
 * with open(path, 'r') as handle:
 * lines = handle.readlines()
 * n_nodes = int(lines.pop(0))
 * for line in lines:
 * (head, tail, cost) = line.split(' ', 2)
 * edges.append(Edge(int(head), int(tail), int(cost)))
 * return list(range(1, n_nodes + 1)), edges
 * 
 * 
 * def maximum_spacing(nodes, edges, k=4):
 * """Find the maximum spacing for a graph of edges with k clusters"""
 * # Sort the edges by cost
 * edges = sorted(edges, key=lambda x: x.cost)
 * # Create our UnionFind data structure
 * nodes = UnionFind(nodes)
 * # While we have more groups then desired clusters
 * while len(nodes.leaders) >= k:
 * # Select the minimum edge and join two clusters
 * min_edge = edges.pop(0)
 * nodes.union(min_edge.head, min_edge.tail)
 * return min_edge.cost
 * 
 * 
 * def read_hamming(path):
 * with open(path, 'r') as handle:
 * lines = handle.readlines()
 * n_nodes, n_bits = lines.pop(0).split(' ', 1)
 * nodes = list()
 * for i, line in enumerate(lines):
 * nodes.append(bytearray([int(i)
 * for i in line.split(' ', int(n_bits) - 1)]))
 * return nodes
 * 
 * def minimum_clusters(nodes, spacing=2):
 * """
 * Find the minimum clusters needed to have a specific spacing
 * """
 * union = UnionFind(nodes)
 * for i in range(1, spacing+1):
 * for node in union.nodes:
 * closest = hamming_possibilities(node, i)
 * for partner in closest:
 * try:
 * union.union(node, partner)
 * except KeyError:
 * pass
 * return len(union.leaders)
 * 
 * 
 * def flip_bit(bit):
 * if bit == 1:
 * return 0
 * if bit == 0:
 * return 1
 * 
 * 
 * def hamming_possibilities(node, distance):
 * """Calculate all possible nodes within a hamming distance of node"""
 * idxs = itertools.combinations(range(len(node)), distance)
 * nodes = list()
 * for shift in idxs:
 * new = copy.copy(node)
 * for pos in shift:
 * new[pos] = flip_bit(node[pos])
 * nodes.append(new)
 * return nodes
 * 
 * nodes =
 * read_hamming('/Users/JustinKim/Documents/workspace/RANDOM/RANDOM/clustering2.
 * txt')
 * print(minimum_clusters(nodes))
 */

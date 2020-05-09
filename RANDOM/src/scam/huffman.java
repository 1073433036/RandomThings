package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class huffman {
	private static class node implements Comparable<node> {
		node left, right;
		long weight;
		int ch = -1;

		public node(long w) {
			weight = w;
		}

		public int compareTo(node o) {
			if (weight > o.weight) {
				return 1;
			}
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("huffman.txt"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numSymbols = Integer.parseInt(st.nextToken());
		int[] weights = new int[numSymbols];
		PriorityQueue<node> nexts = new PriorityQueue<>();
		for (int i = 0; i < numSymbols; i++) {
			st = new StringTokenizer(f.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			node n = new node(weights[i]);
			n.ch = i + 1;
			nexts.add(n);
		}
		node head = null;
		while (nexts.size() > 1) {
			node n1 = nexts.poll();
			node n2 = nexts.poll();

			node nxt = new node(n1.weight + n2.weight);
			nxt.left = n1;
			nxt.right = n2;
			nexts.add(nxt);
			head = nxt;
		}

		codes = new String[numSymbols];
		print(head, "");

		int min = 0, max = 0;
		for (int i = 0; i < numSymbols; i++) {
			if (codes[min].length() > codes[i].length()) {
				min = i;
			}
			if (codes[max].length() < codes[i].length()) {
				max = i;
			}
		}

		System.out.println(codes[max].length());
		System.out.println(codes[min].length());
		f.close();
	}

	// 19,9
	static String[] codes;

	public static void print(node root, String s) {
		if (root.left == null && root.right == null && root.ch != -1) {
			codes[root.ch - 1] = s;
			return;
		}

		print(root.left, s + "0");
		print(root.right, s + "1");
	}
}

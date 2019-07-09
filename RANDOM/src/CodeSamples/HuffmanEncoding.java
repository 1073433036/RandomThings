package CodeSamples;

import java.util.LinkedList;
import java.util.PriorityQueue;

// based on frequencies to compress
public class HuffmanEncoding {
	private class HuffmanNode implements Comparable<HuffmanNode> {
		int data;
		char c;
		HuffmanNode left;
		HuffmanNode right;

		public int compareTo(HuffmanNode other) {
			return this.data - other.data;
		}
	}

	public static void printCode(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	public HuffmanNode createHuffmanTree(char[] chars, int[] freq) {
		PriorityQueue<HuffmanNode> hnq = new PriorityQueue<>();

		for (int i = 0; i < chars.length; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = chars[i];
			hn.data = freq[i];

			hnq.add(hn);
		}

		HuffmanNode root = null;
		while (!hnq.isEmpty()) {
			HuffmanNode hn1 = hnq.poll();
			HuffmanNode hn2 = hnq.poll();

			HuffmanNode eq = new HuffmanNode();
			eq.data = hn1.data + hn2.data;
			eq.c = '-';
			eq.left = hn1;
			eq.right = hn2;
			root = eq;
			hnq.add(eq);
		}

		return root;
	}

	public HuffmanNode efficientCreateHuffmanTree(char[] chars, int[] freq) {
		LinkedList<HuffmanNode> q1=new LinkedList<>();
		LinkedList<HuffmanNode> q2=new LinkedList<>();
		
		
	}

}

package scam;

import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTreeSum {
	private static class Node {
		int[] maxSums = new int[3];
		// [max sum if we didn't take this element, max sum if we take it but
		// not the parent, max sum if we take it and its parent ]

		int value;
		Node parent;
		Node left, right;

		public Node(int val, Node p) {
			value = val;
			parent = p;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numElements = scan.nextInt();
		Node head = new Node(scan.nextInt(), null);
		for (int i = 1; i < numElements; i++) {
			int curr = scan.nextInt();
			Node currNode = head;
			while (true) {
				if (curr < currNode.value) {
					if (currNode.left == null) {
						currNode.left = new Node(curr, currNode);
						break;
					}
					else {
						currNode = currNode.left;
					}
				}
				else if (curr > currNode.value) {
					if (currNode.right == null) {
						currNode.right = new Node(curr, currNode);
						break;
					}
					else {
						currNode = currNode.right;
					}
				}
			}
		}

		LinkedList<Node> left = new LinkedList<>();
		left.add(head);
		while (!left.isEmpty()) {
			Node currNode = left.poll();
			Node parent = currNode.parent;
			// not using this one, pick either any
			currNode.maxSums[0] = Math.max(parent.maxSums[0], Math.max(parent.maxSums[1], parent.maxSums[2]));
			// using this one, pick first 2
			currNode.maxSums[1] = Math.max(parent.maxSums[0], parent.maxSums[1]);
			// using this one and parent, pick middle
			currNode.maxSums[2] = parent.maxSums[1];
		}

		scan.close();
	}
}

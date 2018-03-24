package TRULYRANDOM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BST
{
	static Node root;

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("bst.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bst.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(f.readLine());
			if (st.nextToken().equals("1"))
				insert(Integer.parseInt(st.nextToken()));
			else
				out.println(exist(Integer.parseInt(st.nextToken())) ? "true" : "false");
		}

		out.close();
		f.close();
	}

	public static void insert(int value)
	{
		if (exist(value))
			return;

		if (root == null)
		{
			root = new Node(value);
			return;
		}

		insertVal(root, value);
	}

	private static void insertVal(Node current, int val)
	{
		if (current.value < val)
		{
			if (current.right == null)
				current.right = new Node(val);
			else
				insertVal(current.right, val);
			return;
		}
		if (current.left == null)
			current.left = new Node(val);
		else
			insertVal(current.left, val);
	}

	public static boolean exist(int value)
	{
		return exists(root, value);
	}

	private static boolean exists(Node current, int val)
	{
		if (current == null)
			return false;
		if (current.value == val)
			return true;
		return exists(root.left, val) || exists(root.right, val);
	}
}

class Node
{
	Node left = null, right = null;
	double value;

	public Node(int value)
	{
		this.value = value;
	}
}
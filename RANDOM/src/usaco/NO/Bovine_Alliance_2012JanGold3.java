package usaco.NO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Bovine_Alliance_2012JanGold3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("alliance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("alliance.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		// how many different ways to convert a graph into a dirgraph
		// connected components
		// how many different ways to put directed edges in a component
		// bfs
		// calculate result of each component one by one, keep running product
		// tree is n
		// 1cycle is 2
		// 2+ cycle is impossible
		// bfs back edge

		out.close();
		f.close();
	}
}
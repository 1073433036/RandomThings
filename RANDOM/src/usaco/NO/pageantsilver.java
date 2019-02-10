package usaco.NO;

// import java.util.StringTokenizer;
// import java.io.BufferedReader;
// import java.io.PrintWriter;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class pageantsilver {
	public static ArrayList<Pos>[] spotLoc=new ArrayList[3];
	public static boolean[][] visited=new boolean[50][50];
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pageant.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pageant.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		
		
		out.println();
		out.close();
		f.close();
	}
	
	private class Pos{
		int x;
		int y;
	}
}

package usaco.NO;

//import java.util.StringTokenizer;
//import java.io.BufferedReader;
//import java.io.PrintWriter;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;

import java.io.IOException;

public class dining {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dining.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		
		
		/*
		 * dijsktra from N
		 * 
		 * then dijsktra 
		 * weighted directional
		 * delete all to N
		 * connect only haybale to N weight= length to N - yummy
		 * 
		 */
		
		out.println();
		out.close();
		f.close();
	}
}

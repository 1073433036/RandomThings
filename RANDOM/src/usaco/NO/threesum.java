
package usaco.NO;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;

import java.io.IOException;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class threesum {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("threesum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numElements=Integer.parseInt(st.nextToken());
		int numQueries=Integer.parseInt(st.nextToken());
		

		out.close();
		f.close();
	}
}

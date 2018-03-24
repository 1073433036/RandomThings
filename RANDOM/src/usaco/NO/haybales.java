package usaco.NO;
/*
ID:  justkim
LANG: JAVA
TASK: 
 */


//package usaco;


import java.io.*;          //put tester in file into usaco not bin/src the folder with bin/src in it
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class haybales {
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());    
		int average=0;
		int[] piles=new int[N];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(f.readLine());
			piles[i]=Integer.parseInt(st.nextToken());
			average+=piles[i];
		}
		average/=N;
		int count=0;
		Arrays.sort(piles);
		for(int i=0;i<N/2;i++)
		{
			count+=piles[i]-average;
		}
		out.println(count);                      
		out.close();       
		f.close();             
	}
}
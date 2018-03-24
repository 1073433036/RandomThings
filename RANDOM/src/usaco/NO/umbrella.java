/*
ID:  justkim
LANG: JAVA
TASK: umbrella
 */


package usaco.NO;


import java.io.*;          //put tester in file into usaco not bin/src the folder with bin/src in it
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class umbrella {
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("umbrella.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("umbrella.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] cows=new int[n];
		int[][] umbrellacostsdistance=new int[n][n];
		int[] individualumbrellacosts=new int[m];
		int cost=0;
		int mincost=0x3f3f3f3f;
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(f.readLine());
			cows[i]=Integer.parseInt(st.nextToken());
		}
		int mincostumbrella=0x3f3f3f3f;
		for(int i=0;i<m;i++)
		{
			st=new StringTokenizer(f.readLine());
			individualumbrellacosts[i]=Integer.parseInt(st.nextToken());
			if(individualumbrellacosts[i]<mincostumbrella)
				mincostumbrella=individualumbrellacosts[i];
		}
		Arrays.sort(cows);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(cost>n*mincostumbrella)
				{
					j=n+1;
					continue;
				}
			}
		}
		out.println();                      
		out.close();       
		f.close();             
	}
}
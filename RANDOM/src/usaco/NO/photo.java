/*
ID:  justkim
LANG: JAVA
TASK: 
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

class cow implements Comparable<cow>
{
	private int value;
	private int pos;
	public cow(int a,int p)
	{
		value=a;
		pos=p;
	}
	public int compareTo(cow o) {
		if(photo.afirst( value, o.getValue()))
			return 1;
		else
			return -1;
	}
	public int getValue(){return value;}

}

public class photo{
	public static int[][] pos;
	public static boolean afirst( int a, int b)
	{
		int counta=0;
		for(int i=0;i<5;i++)
		{
			if(pos[i][a]<pos[i][b])
				counta++;
		}
		return counta>=3;
	}
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());    
		pos = new int[5][N];  
		int[] answer=new int[N];
		for(int i=0;i<N*5;i++)
		{
			st=new StringTokenizer(f.readLine());
			pos[(int)(i/5)][Integer.parseInt(st.nextToken())]=i%5;
			answer[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(answer);
		for(int i=0;i<N;i++)
			out.println(answer[i]);
		out.close();       
		f.close();             
	}
}
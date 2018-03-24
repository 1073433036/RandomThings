package usaco.NO;
/*
ID:  justkim
LANG: JAVA
TASK: div7
 */


//package usaco;


import java.io.*;
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class div7 {
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());  
		int[] ids=new int[n];
		int max=0;
		int total=0;
		int div7=0;
		int counter=0;
		int[] notdiv7temp=new int[n];
		Arrays.fill(notdiv7temp, -1);
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(f.readLine());
			ids[i]=Integer.parseInt(st.nextToken())%7;
			total+=ids[i];
			if(ids[i]!=0)
			{
				notdiv7temp[i]=ids[i];
				counter++;
			}
			else
				div7++;
		}
		int[] notdiv7=new int[counter];
		int b=0;
		for(int i=0;i<counter;i++)
		{
			notdiv7[i]=notdiv7temp[b];
			b++;
		}
		for(int i=0;i<n;i++)
		{
			int count=n;
			int newtotal=total;
			for(int j=n-1;j>=0;j--)
			{
				if(newtotal%7!=0)
					newtotal-=notdiv7[j];
				count--;
			}
			if(max<count)
				max=count;
			int temp=notdiv7[n-1];
			notdiv7[n-1]=notdiv7[0];
			notdiv7[0]=temp;
		}
		out.println(max+div7);                      
		out.close();                    
	}
}
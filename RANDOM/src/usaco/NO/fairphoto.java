package usaco.NO;
/*
ID:  justkim
LANG: JAVA
TASK: fairphoto 
 */


//package usaco;


//package usaco;

import java.io.*;
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

class cows implements Comparable<cows>
{
	private int pos;
	private boolean spotted;
	private int prefix;
	public cows(int npos,boolean nspotted)
	{
		pos=npos;
		spotted=nspotted;
	}
	public int getPos()
	{
		return pos;
	}
	public boolean getSpotted()
	{
		return spotted;
	}
	public int getPrefix()
	{
		return prefix;
	}
	public void setPrefix(int pre)
	{
		prefix=pre;
	}
	public int compareTo(cows a)
	{
		if(pos==a.getPos())
			return 0;
		if(pos<a.getPos())
			return -1;
		return 1;
	}
}
public class fairphoto {
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("fairphoto.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());  
		ArrayList<cows> cow=new ArrayList<cows>();
		int prefix=0;
		int max=0;
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(f.readLine());
			cow.add(new cows(Integer.parseInt(st.nextToken()), st.nextToken().equals("S") ?true:false));
		}
		Collections.sort(cow);
		int k=0;
		while(k<cow.size())
		{
			int prevprefix=prefix;
			prefix+=cow.get(k).getSpotted()?-1:1;
			cow.get(k).setPrefix(prefix);
			if(prevprefix>prefix)
			{
				cow.remove(k);
				k--;
			}
			k++;
		}
		int first=0,last=k-1,maxprefix=cow.get(0).getPrefix();
		for(int i=0;i<k;i++)
		{
			if(maxprefix>cow.get(i).getPrefix())
			{
				last=i-1;
				maxprefix=cow.get(i).getPrefix();
				max=Math.max(cow.get(last).getPos()-cow.get(first).getPos(), max);
				first=i;
			}
			else if(i==k-1)
			{
				last=i;
				maxprefix=cow.get(i).getPrefix();
				max=Math.max(cow.get(last).getPos()-cow.get(first).getPos(), max);
			}
			maxprefix=cow.get(i).getPrefix();
		}
		out.println(max);                      
		out.close();     
	}
}
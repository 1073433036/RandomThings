/*
ID:  justkim
LANG: JAVA
TASK: reduce
 */

package usaco.NO;
import java.io.*;
import java.util.*;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class reduce {
	static int max1x=0,max2x=0,max3x=0,max4x=0;
	static int max1y=0,max2y=0,max3y=0,max4y=0;
	static int min1x=40001,min2x=40001,min3x=40001,min4x=40001;
	static int min1y=40001,min2y=40001,min3y=40001,min4y=40001;
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());   
		int length=0,width=0;
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(f.readLine());
			update(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		if(max2x)
		out.println(length*width);                      
		out.close();                    
	}
	public static void update(int newtesterx,int newtestery)
	{
		if(newtesterx>min1x)
		{
			min4x=min3x;
			min3x=min2x;
			min2x=min1x;
			min1x=newtesterx;
		}
		else if(newtesterx>min2x)
		{
			min4x=min3x;
			min3x=min2x;
			min2x=newtesterx;
		}
		else if(newtesterx>min3x)
		{
			min4x=min3x;
			min3x=newtesterx;
		}
		else if(newtesterx>min4x)
		{
			min4x=newtesterx;
		}
		if(newtestery>min1y)
		{
			min4y=min3y;
			min3y=min2y;
			min2y=min1y;
			min1y=newtestery;
		}
		else if(newtestery>min2y)
		{
			min4y=min3y;
			min3y=min2y;
			min2y=newtestery;
		}
		else if(newtestery>min3y)
		{
			min4y=min3y;
			min3y=newtestery;
		}
		else if(newtestery>min4y)
		{
			min4y=newtestery;
		}
		if(newtesterx>max1x)
		{
			max4x=max3x;
			max3x=max2x;
			max2x=max1x;
			max1x=newtesterx;
		}
		else if(newtesterx>max2x)
		{
			max4x=max3x;
			max3x=max2x;
			max2x=newtesterx;
		}
		else if(newtesterx>max3x)
		{
			max4x=max3x;
			max3x=newtesterx;
		}
		else if(newtesterx>max4x)
		{
			max4x=newtesterx;
		}
		if(newtestery>max1y)
		{
			max4y=max3y;
			max3y=max2y;
			max2y=max1y;
			max1y=newtestery;
		}
		else if(newtestery>max2y)
		{
			max4y=max3y;
			max3y=max2y;
			max2y=newtestery;
		}
		else if(newtestery>max3y)
		{
			max4y=max3y;
			max3y=newtestery;
		}
		else if(newtestery>max4y)
		{
			max4y=newtestery;
		}
	}
}
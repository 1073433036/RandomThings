package usaco.NO;
/*
ID:  justkim
LANG: JAVA
TASK: gpsduel
 */


//package usaco;

//put tester in file into usaco not bin/src the folder with bin/src in it
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

class road implements Comparable<road>
{
	private int from;
	private int to;
	private int time;
	public road(int f,int t,int ti)
	{
		from=f;
		to=t;
		time=ti;
	}
	public int getFrom()
	{
		return from;
	}
	public int getTo()
	{
		return to;
	}
	public int getTime()
	{
		return time;
	}
	public int compareTo(road o) {
		if(from<o.getFrom())
			return -1;
		if(from>o.getFrom())
			return 1;
		if(time<o.getTime())
			return -1;
		if(time>o.getTime())
			return 1;
		return 0;
	}
}
public class gpsduel {
	private static int routenum=0;
	public static ArrayList<road> editorderedarray(ArrayList<road> roads,int after)
	{
		ArrayList<road> newroad=roads;
		int first=roads.get(0).getFrom();
		while(true)
			if(roads.get(0).getFrom()!=first&&after==0)
				break;
			else if(roads.get(0).getFrom()==first)
			{
				newroad.remove(0);
				routenum++;
			}
			else
			{
				newroad.remove(0);
				routenum++;
				after--;
			}
		return newroad;
	}
	public static ArrayList<Integer> findfast(ArrayList<road> gpsroads,int intersectionsnum,int currentintersection)
	{
		ArrayList<Integer> route=new ArrayList<Integer>();
		route.add(0);
		ArrayList<Integer> min=new ArrayList<Integer>();
		int mini=0x3f3f3f3f;
		if(currentintersection==intersectionsnum)
		{
			route.add(routenum);
			return route;
		}
		for(int i=0;i<gpsroads.size();i++)
		{
			int temp=routenum;
			ArrayList<Integer> mina=findfast(editorderedarray(gpsroads,i),intersectionsnum,currentintersection+1);
			if(mina.get(0)<mini)
			{
				mini=mina.get(0);
				min=mina;
			}
			routenum=temp;
		}
		for(int i=1;i<min.size();i++)
			route.add(min.get(i));
		return route;
	}
	public static void main (String [] args) throws IOException {   
		BufferedReader f = new BufferedReader(new FileReader("gpsduel.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gpsduel.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int intersectionsnum = Integer.parseInt(st.nextToken());  
		st=new StringTokenizer(f.readLine());
		int roadsnum = Integer.parseInt(st.nextToken());   
		ArrayList<road> gps1roads=new ArrayList<road>();
		ArrayList<road> gps2roads=new ArrayList<road>();
		for(int i=0;i<roadsnum;i++)
		{
			st=new StringTokenizer(f.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			gps1roads.add(new road(from,to,Integer.parseInt(st.nextToken())));
			gps2roads.add(new road(from,to, Integer.parseInt(st.nextToken()))); 
		}
		Collections.sort(gps1roads);
		Collections.sort(gps2roads);
		int count=0;
		ArrayList<Integer> route1=findfast(gps1roads,intersectionsnum,0);
		ArrayList<Integer> route2=findfast(gps2roads,intersectionsnum,0);
		for(int i=1;i<route1.size()&&i<route2.size();i++)
		{
			if(route1.get(i)!=route2.get(i))
			{
				count++;
				route1=findfast(gps1roads,intersectionsnum,i);
				route2=findfast(gps2roads,intersectionsnum,i);
			}
		}
		out.println(count+Math.abs(route1.size()-route2.size()));                      
		out.close();    
		f.close();
	}
}
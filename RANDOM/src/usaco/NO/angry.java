package usaco.NO;
/*
ID:  justkim
LANG: JAVA
TASK: angry
*/


//package usaco;
import java.io.IOException;
import java.util.Arrays;

import usaco.BufferedReader;
import usaco.BufferedWriter;
import usaco.FileReader;
import usaco.FileWriter;
import usaco.PrintWriter;
import usaco.StringTokenizer;

public class angry {
  public static void main (String [] args) throws IOException {   
    BufferedReader f = new BufferedReader(new FileReader("angry.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());    
    int k = Integer.parseInt(st.nextToken());   
    int[] bales=new int[n];
    for(int i=0;i<n;i++)
    {
    	st=new StringTokenizer(f.readLine());
    	bales[i]=Integer.parseInt(st.nextToken());
    }
    Arrays.sort(bales);
    int[][] split=new int[k][2];
    for(int i=0;i<k;i++)
    {
    	split[i][0]=bales[i*((int)(bales.length/k))];
    	split[i][1]=bales[i*((int)(bales.length/k))+(int)(bales.length/k)-1];
    }
    int[] max=new int[k];
    for(int i=0;i<k;i++)
    {
    	max[i]=(int)Math.ceil((split[i][0]+split[i][1])/2.0)-split[i][0];
    }
    int maximum=0;
    for(int i=0;i<k;i++)
    	if(maximum<max[i])
    		maximum=max[i];
    out.println(maximum);                      
    out.close();                    
  }
}
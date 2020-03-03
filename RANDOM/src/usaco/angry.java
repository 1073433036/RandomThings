
package usaco;

//import java.util.StringTokenizer;
//import java.io.BufferedReader;
//import java.io.PrintWriter;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;

import java.io.IOException;

public class angry {
  public static void main (String [] args) throws IOException {   
    BufferedReader f = new BufferedReader(new FileReader("angry.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int numBales=Integer.parseInt(st.nextToken());
    int numCows=Integer.parseInt(st.nextToken());
    
    int[] bales=new int[numBales];
    
    int left= 0;
    int right=500000;
    while(left<right) {
    	int mid = (left+right)/2;
    	int count =0;
    	for(int i=0;i<numBales;i++) {
    		
    	}
    }
    
    out.close();
	f.close();             
  }
}

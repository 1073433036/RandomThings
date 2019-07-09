package scam;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maxpaircombo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Integer[] A = new Integer[size];
		Integer[] B = new Integer[size];
		for (int i = 0; i < size; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < size; i++) {
			B[i] = scan.nextInt();
		}
		Arrays.sort(A, Collections.reverseOrder());
		Arrays.sort(B, Collections.reverseOrder());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.add(0l);
		boolean[][] visited = new boolean[size][size];
		while (size>0) {
			int a=(int)(pq.peek()/100000);
			int b=(int)(pq.poll()%100000);
		
			System.out.println(A[a]+B[b]);
			size--;
			if(!visited[a+1][b]) {
				pq.add((a+1)*100000l+b);
			}
			if(!visited[a][b+1]) {
				pq.add(a*100000l+b+1);
			}
		}
		
		scan.close();
	}
}

package scam;

import java.util.Arrays;
import java.util.TreeMap;

public class sumexactlyK {
	public static void main(String[] args) {
		int[] a = { 0, 2, -3, 5, -1, 2, 1, 3, -2, 2, 1 };
		int n = 11;
		int k = 5;
		int[] ps = new int[n];
		for (int i = 1; i < n; i++) {
			ps[i] = ps[i - 1] + a[i];
		}
		System.out.println(Arrays.toString(ps));
		TreeMap<Integer,Integer> counts=new TreeMap<>();
		int result=0;
		for(int i=1;i<n;i++) {
			int target=ps[i]-k;
			if(counts.containsKey(target)) {
				System.out.println(i);
				result+=counts.get(target);
			}
			if(counts.containsKey(ps[i])) {
				counts.put(ps[i],counts.get(ps[i])+1);
			}
			else {
				counts.put(ps[i], 1);
			}
		}
		
		System.out.println(result);
	}
}

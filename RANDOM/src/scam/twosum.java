package scam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class twosum {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("2sum.txt"));
		StringTokenizer st;
		HashSet<Long> nums = new HashSet<>();
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			nums.add(Long.parseLong(st.nextToken()));
		}
		int count = 0;
		for (int t = -10000; t <= 10000; t++) {
			for (long i : nums) {
				if (nums.contains(t - i) && t - i != i) {
					System.out.println(t + " " + (t - i) + " " + i);
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		f.close();
	}
}
// answer is 427
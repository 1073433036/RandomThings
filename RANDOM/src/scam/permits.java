package scam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class permits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			arr.add(scan.nextInt());
		}
		System.out.println(getLine(arr));
		scan.close();
	}

	public static int getLine(List<Integer> staffsDesks) {
		int n = staffsDesks.size();
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (staffsDesks.get(i) < staffsDesks.get(i - 1)) {
				count++;
			}
		}
		return count;
	}

}

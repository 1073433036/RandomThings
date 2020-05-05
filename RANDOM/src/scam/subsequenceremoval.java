package scam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class subsequenceremoval {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			arr.add(scan.nextInt());
		}
		System.out.println(findSubsequence(arr));
		scan.close();
	}

	public static List<Integer> findSubsequence(List<Integer> arr) {
		List<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> dupes = new HashSet<>();
		for (int i = 0; i < arr.size(); i++) {
			if (dupes.contains(arr.get(i))) {
				res.add(arr.get(i));
			}
			else {
				dupes.add(arr.get(i));
			}
		}

		Collections.sort(res);
		if (res.size() == 0) {
			return new ArrayList<Integer>();
		}
		int j = res.size() - 1;
		for (int i = arr.size() - 1; i >= 0; i--) {
			if (arr.get(i) == res.get(j)) {
				j--;
			}
			if (j == -1) {
				return res;
			}
		}

		List<Integer> fail = new ArrayList<Integer>();
		fail.add(-1);
		return fail;
	}
}

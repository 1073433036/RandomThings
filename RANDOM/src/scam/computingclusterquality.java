package scam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class computingclusterquality {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> spd = new ArrayList<>();
		List<Integer> rel = new ArrayList<>();
		int n = scan.nextInt();
		int mx = scan.nextInt();
		for (int i = 0; i < n; i++) {
			spd.add(scan.nextInt());
			rel.add(scan.nextInt());
		}
		System.out.println(maximumClusterQuality(spd, rel, mx));
		scan.close();
	}

	public static long maximumClusterQuality(List<Integer> speed, List<Integer> reliability, int maxMachines) {

	}

}

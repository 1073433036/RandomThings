
// package usacoFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class electioncow implements Comparable<electioncow> {
	public int round1;
	public int round2;
	public int pos;

	public electioncow(int r1, int r2, int pos) {
		round1 = r1;
		round2 = r2;
		this.pos = pos;
	}

	public int compareTo(electioncow o) {
		if (this.round1 > o.round1)
			return 1;
		return -1;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt();
		ArrayList<electioncow> ecow = new ArrayList<electioncow>();
		for (int i = 0; i < n; i++)
			ecow.add(new electioncow(scan.nextInt(), scan.nextInt(), i + 1));
		Collections.sort(ecow, Collections.reverseOrder());
		electioncow max = ecow.get(0);
		for (int i = 1; i < k; i++)
			if (max.round2 < ecow.get(i).round2)
				max = ecow.get(i);

		System.out.println(max.pos);
		scan.close();
	}
}
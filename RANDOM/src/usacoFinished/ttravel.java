package usacoFinished;

import java.util.ArrayList;
import java.util.Scanner;

public class ttravel {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numQueries = scan.nextInt();
		ArrayList<ArrayList<Integer>> cows = new ArrayList<>();
		cows.add(new ArrayList<Integer>());
		for (int i = 0; i < numQueries; i++) {
			char query = scan.next().charAt(0);

			if (query == 'a') {
				ArrayList<Integer> next = new ArrayList<>();
				next.addAll(cows.get(cows.size() - 1));
				int add = scan.nextInt();
				next.add(add);
				cows.add(next);
				System.out.println(add);
			}
			else if (query == 's') {
				ArrayList<Integer> next = new ArrayList<>();
				next.addAll(cows.get(cows.size() - 1));
				next.remove(next.size() - 1);
				cows.add(next);
				if (next.size() == 0) {
					System.out.println(-1);
					continue;
				}
				System.out.println(next.get(next.size() - 1));
			}
			else {
				int timeSkip = scan.nextInt();
				cows.add(cows.get(timeSkip - 1));
				if (cows.get(cows.size() - 1).size() == 0) {
					System.out.println(-1);
					continue;
				}
				System.out.println(cows.get(cows.size() - 1).get(cows.get(cows.size() - 1).size() - 1));
			}
		}

		scan.close();
	}
}

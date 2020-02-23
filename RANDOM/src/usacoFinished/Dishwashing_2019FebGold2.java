
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dishwashing_2019FebGold2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dishes.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dishes.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int numDishes = Integer.parseInt(st.nextToken());
		int[] dishes = new int[numDishes + 1];
		for (int i = 0; i < numDishes; i++) {
			st = new StringTokenizer(f.readLine());
			dishes[i] = Integer.parseInt(st.nextToken());
		}

		dishes[numDishes] = Integer.MIN_VALUE;
		ArrayList<LinkedList<Integer>> stacks = new ArrayList<>(numDishes);
		stacks.add(new LinkedList<Integer>());
		stacks.get(0).add(dishes[0]);
		int lstack = 0;
		int clean = -1;
		for (int i = 1; i <= numDishes; i++) {
			if (dishes[i] < clean) {
				out.println(i);
				break;
			}
			int left = lstack;
			int right = stacks.size() - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				int bottom = stacks.get(mid).peekFirst();
				if (dishes[i] < bottom || (bottom == stacks.get(mid).peek() && dishes[i] == bottom)) {
					right = mid;
				}
				else {
					left = mid + 1;
				}
			}

			int bottom = stacks.get(right).peekFirst();
			int top = stacks.get(right).peekLast();
			if (left == right && right == stacks.size() - 1
					&& (dishes[i] > bottom || dishes[i] == bottom && dishes[i] != top)) {
				stacks.add(new LinkedList<Integer>());
				stacks.get(right + 1).add(dishes[i]);
			}
			else if (dishes[i] <= stacks.get(right).peekLast()) {
				stacks.get(right).add(dishes[i]);
			}
			else {
				while (lstack < stacks.size() && dishes[i] > stacks.get(lstack).peekLast()) {
					clean = stacks.get(lstack).pollLast();
					if (stacks.get(lstack).isEmpty()) {
						lstack++;
					}
				}
				if (dishes[i] != clean) {
					stacks.get(lstack).add(dishes[i]);
				}
				if (stacks.get(lstack).isEmpty()) {
					lstack++;
				}
			}
		}

		out.close();
		f.close();
	}
}

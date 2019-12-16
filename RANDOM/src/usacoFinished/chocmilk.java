package usacoFinished;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class chocmilk {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numJoints = scan.nextInt();
		ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
		ArrayList<ArrayList<Integer>> rconnections = new ArrayList<>();

		for (int i = 0; i < numJoints; i++) {
			connections.add(new ArrayList<Integer>());
			rconnections.add(new ArrayList<Integer>());
		}

		int[] indegree = new int[numJoints];
		int[] outdegree = new int[numJoints];
		for (int i = 0; i < numJoints - 1; i++) {
			int src = scan.nextInt() - 1;
			int dest = scan.nextInt() - 1;
			connections.get(src).add(dest);
			rconnections.get(dest).add(src);
			indegree[dest]++;
			outdegree[src]++;
		}

		int cow = 0;
		int tank = 0;
		for (int i = 0; i < numJoints; i++) {
			if (indegree[i] == 0) {
				cow = i;
			}
			if (outdegree[i] == 0) {
				tank = i;
			}
		}

		LinkedList<Integer> jointsleft = new LinkedList<>();
		jointsleft.add(cow);
		int endjoint = tank;
		while (!jointsleft.isEmpty()) {
			int cur = jointsleft.poll();

			if (outdegree[cur] > 1) {
				endjoint = cur;
				break;
			}

			for (int conn : connections.get(cur)) {
				jointsleft.add(conn);
			}
		}

		jointsleft.clear();
		jointsleft.add(tank);
		int startjoint = cow;
		while (!jointsleft.isEmpty()) {
			int cur = jointsleft.poll();

			if (indegree[cur] > 1) {
				startjoint = cur;
				break;
			}

			for (int conn : rconnections.get(cur)) {
				jointsleft.add(conn);
			}
		}

		jointsleft.clear();
		jointsleft.add(startjoint);
		while (!jointsleft.isEmpty()) {
			int cur = jointsleft.poll();
			if (cur != cow) {
				System.out.println(cur + 1);
			}

			if (cur == endjoint) {
				break;
			}
			for (int conn : connections.get(cur)) {
				jointsleft.add(conn);
			}
		}

		scan.close();
	}
}

/*
ID: juskim81
LANG: JAVA
TASK: gift1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.HashMap;

public class gift1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numPeople = Integer.parseInt(st.nextToken());
		String[] names = new String[numPeople];
		HashMap<String, Integer> accounts = new HashMap<>();
		for (int i = 0; i < numPeople; i++) {
			st = new StringTokenizer(f.readLine());
			names[i] = st.nextToken();
			accounts.put(names[i], 0);
		}

		for (int i = 0; i < numPeople; i++) {
			st = new StringTokenizer(f.readLine());
			String giver = st.nextToken();
			st = new StringTokenizer(f.readLine());
			int amt = Integer.parseInt(st.nextToken());
			int numGive = Integer.parseInt(st.nextToken());
			if (numGive != 0) {
				accounts.put(giver, accounts.get(giver) - amt + amt % numGive);
			}
			for (int j = 0; j < numGive; j++) {
				st = new StringTokenizer(f.readLine());
				String receiver = st.nextToken();
				accounts.put(receiver, accounts.get(receiver) + amt / numGive);
			}
		}

		for (int i = 0; i < numPeople; i++) {
			out.println(names[i] + " " + accounts.get(names[i]));
		}
		out.close();
		f.close();
	}
}

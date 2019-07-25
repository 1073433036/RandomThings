
//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Block_Game_2016DecBronze2 {
	public static String mergeStrings(String a, String b) {
		String newstring = b;
		boolean[] used = new boolean[b.length()];
		for (int i = 0; i < b.length(); i++)
			used[i] = false;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.substring(i, i + 1).equals(b.substring(j, j + 1)) && !used[j]) {
					used[j] = true;
					j = b.length() + 123;
				}
				if (j + 1 == b.length())
					newstring += a.substring(i, i + 1);
			}
		}
		return newstring;
	}

	public static int alphabetplace(String a) {
		switch (a) {
			case "a":
				return 1;
			case "b":
				return 2;
			case "c":
				return 3;
			case "d":
				return 4;
			case "e":
				return 5;
			case "f":
				return 6;
			case "g":
				return 7;
			case "h":
				return 8;
			case "i":
				return 9;
			case "j":
				return 10;
			case "k":
				return 11;
			case "l":
				return 12;
			case "m":
				return 13;
			case "n":
				return 14;
			case "o":
				return 15;
			case "p":
				return 16;
			case "q":
				return 17;
			case "r":
				return 18;
			case "s":
				return 19;
			case "t":
				return 20;
			case "u":
				return 21;
			case "v":
				return 22;
			case "w":
				return 23;
			case "x":
				return 24;
			case "y":
				return 25;
			case "z":
				return 26;
			default:
				return 0;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());

		String[] stringlistup = new String[n];
		String[] stringlistdown = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			stringlistup[i] = st.nextToken();
			stringlistdown[i] = st.nextToken();
		}

		int[] alphabetcount = new int[26];
		for (int i = 0; i < 26; i++)
			alphabetcount[i] = 0;

		for (int i = 0; i < n; i++) {
			String down = stringlistdown[i];
			String up = stringlistup[i];
			String newstring;
			String max;
			String min;
			if (up.length() > down.length()) {
				min = down;
				max = up;
			}
			else {
				min = up;
				max = down;
			}
			newstring = mergeStrings(min, max);
			for (int j = 0; j < newstring.length(); j++)
				alphabetcount[alphabetplace(newstring.substring(j, j + 1)) - 1]++;
		}

		for (int i = 0; i < 26; i++)
			out.println(alphabetcount[i]);

		out.close();
		f.close();
	}
}
package TRULYRANDOM;

import java.util.HashSet;
import java.util.Scanner;

public class a {
	public static void main(String args[]) {
		HashSet<Integer> a = new HashSet<>();
		Scanner scan = new Scanner(System.in);
		int wordcount = scan.nextInt();
		String[] words = new String[wordcount];
		for (int i = 0; i < wordcount; i++)
			words[i] = scan.next();
		int[] result = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int count = 0;
			if (words[i].length() >= 2) {
				for (int j = 0; j < words[i].length() - 1; j++)
					if (words[i].substring(j, j + 1).equals(words[i].substring(j + 1, j + 2))) {
						int lettersInRow = 1;
						while (j < words[i].length() - 1
								&& words[i].substring(j, j + 1).equals(words[i].substring(j + 1, j + 2))) {
							j++;
							lettersInRow++;
						}
						count += lettersInRow / 2;
					}
				result[i] = count;
			}
			else
				result[i] = 0;

		}
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}

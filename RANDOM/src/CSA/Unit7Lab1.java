/**
 * This is a word count program
 * 
 * @author Justin Kim
 */
package CSA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Unit7Lab1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Input your command: ");
		String[] commandList = input.nextLine().split(" ");
		File file = new File(commandList[commandList.length - 1]);
		Scanner fileInput = new Scanner(file);
		int[] counts = { 0, 0, 0, 0 };
		while (fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			counts[0] += line.length();
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == ' ' || line.charAt(i) == '\t') {
					counts[1]++;
				}
				else if (line.charAt(i) == '.') {
					counts[2]++;
				}
			}
			// last word no space
			counts[1]++;

			counts[3]++;
		}

		String specified = commandList[1];
		if (specified.charAt(0) != '-') {
			System.out.println("Characters: " + counts[0]);
			System.out.println("Words: " + counts[1]);
			System.out.println("Sentences: " + counts[2]);
			System.out.println("Paragraphs: " + counts[3]);

		}
		else {
			if (specified.contains("c")) {
				System.out.println(counts[0]);
			}
			if (specified.contains("w")) {
				System.out.println(counts[1]);
			}
			if (specified.contains("s")) {
				System.out.println(counts[2]);
			}
			if (specified.contains("p")) {
				System.out.println(counts[3]);
			}
		}

		input.close();
		fileInput.close();
	}
}

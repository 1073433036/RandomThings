package usaco;

import java.util.Scanner;

public class BufferedReader {
	public BufferedReader(FileReader str) {
	}

	static Scanner scan = new Scanner(System.in);

	public String readLine() {
		counter--;
		return scan.nextLine();
	}

	public void close() {
		scan.close();
	}

	int counter = -1;

	public boolean ready() {
		if (counter < 0) {
			System.out.println("how many?");
			counter = scan.nextInt();
			scan.nextLine();
		}
		if (counter == 0) {
			return false;
		}
		return true;
	}
}

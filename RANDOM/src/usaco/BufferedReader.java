package usaco;

import java.util.Scanner;

public class BufferedReader {
	public BufferedReader(FileReader str) {
	}

	static Scanner scan = new Scanner(System.in);

	public String readLine() {
		return scan.nextLine();
	}

	public void close() {
		scan.close();
	}
}

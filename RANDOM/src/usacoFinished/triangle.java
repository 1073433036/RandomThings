package usacoFinished;

import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[][] triangles = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				triangles[i][j] = scan.nextInt();
			}
		}

		int[][] sumTriangles = new int[size+1][size + 1];
		for (int i = size - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				sumTriangles[i][j] = triangles[i][j] + Math.max(sumTriangles[i + 1][j + 1], sumTriangles[i + 1][j]);
			}
		}

		System.out.println(sumTriangles[0][0]);
		scan.close();
	}
}

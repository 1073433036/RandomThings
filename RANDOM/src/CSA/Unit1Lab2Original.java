/**
 * This class/program asks the user for six numbers and puts it in a 2x3 table
 * going
 * from left to right and top to bottom. It then calculates the sum of each row
 * and column and then the total sum.
 * 
 * 
 * @author Justin Kim
 * 
 */
package CSA;

import java.util.Scanner;

public class Unit1Lab2Original {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] mtrx = new int[3][2];
		System.out.print("Enter 6 integers separated by a space:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				mtrx[i][j] = input.nextInt();
			}
		}

		System.out.println("\n\n\tValue\tValue\tTotal");
		int[] csum = { 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			int rsum = 0;
			for (int j = 0; j < 2; j++) {
				rsum += mtrx[i][j];
				csum[j] += mtrx[i][j];
				System.out.print("\t" + mtrx[i][j]);
			}
			csum[2] += rsum;
			System.out.println("\t" + rsum);
		}

		for (int i = 0; i < 3; i++) {
			System.out.print("\t-----");
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("\t" + csum[i]);
		}

	}

}

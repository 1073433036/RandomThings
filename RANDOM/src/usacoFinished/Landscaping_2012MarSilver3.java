package usacoFinished;

import java.util.Scanner;

public class Landscaping_2012MarSilver3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBeds = scan.nextInt();
		int addCost = scan.nextInt();
		int removeCost = scan.nextInt();
		int replaceCost = scan.nextInt();

		int[] currBeds = new int[numBeds];
		int sumcurr = 0;
		int[] changeBeds = new int[numBeds];
		int sumdiff = 0;
		for (int i = 0; i < numBeds; i++) {
			currBeds[i] = scan.nextInt();
			sumcurr += currBeds[i];
			changeBeds[i] = scan.nextInt();
			sumdiff += changeBeds[i];
		}

		int[] b1 = new int[sumcurr];
		int[] b2 = new int[sumdiff];
		int count = 0;
		for (int i = 0; i < numBeds; i++) {
			for (int j = 0; j < currBeds[i]; j++) {
				b1[count++] = i;
			}
		}

		count = 0;
		for (int i = 0; i < numBeds; i++) {
			for (int j = 0; j < changeBeds[i]; j++) {
				b2[count++] = i;
			}
		}

		int[][] editDistance = new int[sumcurr + 1][sumdiff + 1];
		// editDistance[i][j]= # edits to make i numbers into j numbers
		// editDistance[i][j]=
		// min(ed[i-1][j-1]+z*(i-j), ed[i][j-1]+x, ed[i-1][j]+y

		for (int i = 0; i <= sumcurr; i++) {
			editDistance[i][0] = i * removeCost;
		}
		for (int j = 0; j <= sumdiff; j++) {
			editDistance[0][j] = j * addCost;
		}

		for (int i = 1; i <= sumcurr; i++) {
			for (int j = 1; j <= sumdiff; j++) {
				editDistance[i][j] = Math.min(
						editDistance[i - 1][j - 1] + replaceCost * Math.abs(b1[i - 1] - b2[j - 1]),
						Math.min(editDistance[i][j - 1] + addCost, editDistance[i - 1][j] + removeCost));
			}
		}

		System.out.println(editDistance[sumcurr][sumdiff]);
		scan.close();
	}
}

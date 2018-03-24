package MATHISNOTMETH;

import java.io.*;
import java.util.*;

public class SetMovesSolver
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);

		// // input rows and columns
		// System.out.print("Input # of rows and columns separated by a space:
		// ");// 2 2
		// int rows = scan.nextInt();
		// int columns = scan.nextInt();

		// input cards
		// scan.nextLine();
		System.out.println("Input cards separated by a space. Use numbers instead of attributes: ");// 1233
																									// 1232
																									// 1111...
		String input = scan.nextLine();

		// split the input to get individual cards in number form
		ArrayList<Integer> cards = new ArrayList<>();
		String[] splitInput = input.split(" ");
		for (String card : splitInput)
			cards.add(Integer.parseInt(card));

		// find every possible card set
		ArrayList<Integer> result = solve(cards);

		for (int i = 0; i < result.size(); i += 3)
		{
			// // i
			// int col = (result.get(i) % columns == 0 ? columns : result.get(i)
			// % columns),
			// row = (result.get(i) - col) / col + 1;
			// System.out.print(row + " " + col + " ");
			//
			// // j
			// col = (result.get(i + 1) % columns == 0 ? columns : result.get(i
			// + 1) % columns);
			// row = (result.get(i + 1) - col) / col + 1;
			// System.out.print(row + " " + col + " ");
			//
			// // k
			// col = (result.get(i + 2) % columns == 0 ? columns : result.get(i
			// + 2) % columns);
			// row = ((result.get(i + 2) - col) / col) + 1;
			// System.out.print(row + " " + col);

			System.out.print(result.get(i) + " " + result.get(i + 1) + " " + result.get(i + 2) + "  ");
		}

		scan.close();
	}

	private static ArrayList<Integer> solve(ArrayList<Integer> cards)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < cards.size(); i++)
			for (int j = i + 1; j < cards.size(); j++)
			{
				int find = lookFor(cards.get(i) + cards.get(j));
				for (int k = j + 1; k < cards.size(); k++)
					if (find == cards.get(k))
					{
						result.add(i + 1);
						result.add(j + 1);
						result.add(k + 1);
					}
			}
		return result;
	}

	private static int lookFor(int sum)
	{
		int one = sum / 1000, two = (sum - one * 1000) / 100, three = (sum - one * 1000 - two * 100) / 10,
				four = sum - one * 1000 - two * 100 - three * 10;

		return (3 - (one % 3)) * 1000 + (3 - (two % 3)) * 100 + (3 - (three % 3)) * 10 + 3 - (four % 3);
	}
}
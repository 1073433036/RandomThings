package MATHISNOTMETH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SetMovesSolver
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);

		// input cards
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

		// sets of 3
		for (int i = 0; i < result.size(); i += 3)
			System.out.println(result.get(i) + " " + result.get(i + 1) + " " + result.get(i + 2) + "  ");

		scan.close();
	}

	private static ArrayList<Integer> solve(ArrayList<Integer> cards)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < cards.size(); i++)
			for (int j = i + 1; j < cards.size(); j++)
			{// for every possible 2 card combos, find third card that completes
				int find = lookFor(cards.get(i) + cards.get(j));  // set
				for (int k = j + 1; k < cards.size(); k++)
					if (find == cards.get(k))
					{ // put in set of 3
						result.add(i + 1);
						result.add(j + 1);
						result.add(k + 1);
					}
			}
		return result;
	}

	private static int lookFor(int sum)
	{// quality 1,2,3,4
		int one = sum / 1000, two = (sum - one * 1000) / 100, three = (sum - one * 1000 - two * 100) / 10,
				four = sum - one * 1000 - two * 100 - three * 10;

		// quality looking for is 3-(each quality%3)
		// amount from next multiple of three greater than quality
		return (3 - (one % 3)) * 1000 + (3 - (two % 3)) * 100 + (3 - (three % 3)) * 10 + 3 - (four % 3);
	}
}

public class Anonymous
{
	public int howMany(String[] headlines, String[] messages)
	{
		int[] howManyCharsAvailable = new int[26];
		int[][] howManyCharsNeeded = new int[messages.length][26];
		int count = messages.length;

		for (String b : headlines)
			for (String a : b.toLowerCase().split(""))
			{
				int num = alphabetplace(a);
				if (num == 0)
					continue;
				howManyCharsAvailable[num - 1]++;
			}
		for (int i = 0; i < messages.length; i++)
			for (String a : messages[i].toLowerCase().split(""))
			{
				int num = alphabetplace(a);
				if (num == 0)
					continue;
				howManyCharsNeeded[i][num - 1]++;
			}

		for (int j = 0; j < messages.length; j++)
			for (int i = 0; i < 26; i++)
				if (howManyCharsNeeded[j][i] > howManyCharsAvailable[i])
				{
					count--;
					break;
				}

		return count;
	}

	// public static void main(String args[])
	// {
	// String[] headlines={"Programming is fun "};
	//
	// String[] messages={"program ", " programmer ", " gaming ", " sing ", " NO
	// FUN " };
	//
	// System.out.println(howMany(headlines,messages));
	// }
	public static int alphabetplace(String a)
	{
		switch (a)
		{
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
}

import java.util.HashSet;

public class SimpleWordGame
{
	public int points(String[] player, String[] dictionary)
	{
		HashSet<String> playerRememberedWords = new HashSet<>();
		int score = 0;

		for (String w : player)
			playerRememberedWords.add(w);

		for (String a : playerRememberedWords)
			for (int j = 0; j < dictionary.length; j++)
				if (a.equals(dictionary[j]))
					score += Math.pow(dictionary[j].length(), 2);

		return score;
	}

}

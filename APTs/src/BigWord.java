import java.util.HashMap;
import java.util.Map.Entry;

public class BigWord
{
	public String most(String[] sentences)
	{
		// word count
		HashMap<String, Integer> wordCount = new HashMap<>();

		// count words
		for (String sentence : sentences)
		{
			// words in sentences
			String[] words = sentence.toLowerCase().split(" ");
			for (int i = 0; i < words.length; i++)
				if (wordCount.containsKey(words[i]))
					wordCount.put(words[i], wordCount.get(words[i]) + 1);
				else
					wordCount.put(words[i], 1);
		}

		// find word there is most of
		int max = 0;
		String greatest = "";
		for (Entry<String, Integer> entry : wordCount.entrySet())
		{
			int value = entry.getValue();
			if (value > max)
			{
				max = value;
				greatest = entry.getKey();
			}
		}

		return greatest;
	}
}

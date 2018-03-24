
public class HuffmanDecoding
{
	public String decode(String archive, String[] dictionary)
	{
		String text = "";

		for (int i = 0; i < archive.length();)
		{
			for (int j = 0; j < dictionary.length; j++)
			{
				String word = dictionary[j];

				if (word.length() + i > archive.length())
					continue;

				if (word.equals(archive.substring(i, i + word.length())))
				{
					text += (char) (j + 65);
					i += word.length();
					break;
				}
			}
		}

		return text;
	}

	// public static void main(String[] args)
	// {
	// String[] a = {"0", "111", "10"};
	// System.out.println(decode("10111010", a));
	// }
}

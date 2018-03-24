package weird;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class noAI1
{
	public static void main(String[] args) throws IOException
	{
		// input
		Scanner scan = new Scanner(System.in);
		BufferedReader f = new BufferedReader(new FileReader("sentences.txt"));
		Random rand = new Random();

		ArrayList<String> sentences = new ArrayList<>();
		String sentence = f.readLine();
		while (true)
		{
			if (sentence == null)
				break;
			sentences.add(sentence.substring(sentence.length() - 1).equals("\"")
					? sentence.substring(1, sentence.length() - 3) : sentence.substring(1, sentence.length() - 2));
			try
			{
				sentence = f.readLine();
			}
			catch (IOException e)
			{
				break;
			}
		}

		// conversing
		System.out.println("Say \"Bye.\" if you want to go.");
		System.out.println("Hi!");
		while (true)
		{
			String input = scan.nextLine();
			if (input.equals("Bye."))
				break;
			System.out.println(sentences.get(rand.nextInt(sentences.size())));
		}

		// closing up
		scan.close();
		f.close();
	}
}

package weird;

import java.io.*;          // put tester in file into usaco not bin/src the
					          // folder with bin/src in it
import java.util.*;

public class GrammaticallyCorrect
{
	public static void main(String[] args) throws IOException
	{
		// init
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		BufferedReader in = new BufferedReader(new FileReader("sentences.txt"));
		ArrayList<String> sentences = new ArrayList<>();
		String sent = in.readLine();
		while (sent != null)
		{
			sentences.add(sent);
			try
			{
				sent = in.readLine();
			}
			catch (IOException e)
			{
				break;
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter("sentences.txt"));
		String[] punct =
			{ ",", ":", ";", "'s", "'" };
		String[] endpunct =
			{ ".", "?", "!" };

		// infinite loop
		while (true)
		{
			// grammar check
			int wordcount = rand.nextInt(10);
			String sentence = "";
			for (int i = 0; i < wordcount; i++)
			{
				if (i != 0)
					sentence += " ";
				sentence += getWord(rand.nextInt(377499));
				if (rand.nextInt(100) < 33 && i < wordcount - 1)
					sentence += punct[rand.nextInt(punct.length)];
			}
			sentence += endpunct[rand.nextInt(endpunct.length)];
			sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

			System.out.println(sentence);

			System.out.print("Good(1) or bad(2): ");
			int input = scan.nextInt();
			if (input == 1)
				sentences.add("\"" + sentence + "\",");
			else if (input != 2)
				break;
		}

		// output sentences for file input
		for (String s : sentences)
			out.println(s);

		// closing up
		in.close();
		out.close();
		scan.close();
	}

	public static String getWord(int wordnum)
	{
		if (wordnum < 7400)
			return words1.words1[wordnum];
		if (wordnum < 14800)
			return words2.words2[wordnum - 7400];
		if (wordnum < 22200)
			return words3.words3[wordnum - 14800];
		if (wordnum < 29600)
			return words4.words4[wordnum - 22200];
		if (wordnum < 37000)
			return words5.words5[wordnum - 29600];
		if (wordnum < 44400)
			return words6.words6[wordnum - 37000];
		if (wordnum < 51800)
			return words7.words7[wordnum - 44400];
		if (wordnum < 59200)
			return words8.words8[wordnum - 51800];
		if (wordnum < 66600)
			return words9.words9[wordnum - 59200];
		if (wordnum < 74000)
			return words10.words10[wordnum - 66600];
		if (wordnum < 81400)
			return words11.words11[wordnum - 74000];
		if (wordnum < 88800)
			return words12.words12[wordnum - 81400];
		if (wordnum < 96200)
			return words13.words13[wordnum - 88800];
		if (wordnum < 103600)
			return words14.words14[wordnum - 96200];
		if (wordnum < 111000)
			return words15.words15[wordnum - 103600];
		if (wordnum < 118400)
			return words16.words16[wordnum - 111000];
		if (wordnum < 125800)
			return words17.words17[wordnum - 118400];
		if (wordnum < 133200)
			return words18.words18[wordnum - 125800];
		if (wordnum < 140600)
			return words19.words19[wordnum - 133200];
		if (wordnum < 148000)
			return words20.words20[wordnum - 140600];
		if (wordnum < 155400)
			return words21.words21[wordnum - 148000];
		if (wordnum < 162800)
			return words22.words22[wordnum - 155400];
		if (wordnum < 170200)
			return words23.words23[wordnum - 162800];
		if (wordnum < 177600)
			return words24.words24[wordnum - 170200];
		if (wordnum < 185000)
			return words25.words25[wordnum - 177600];
		if (wordnum < 192400)
			return words26.words26[wordnum - 185000];
		if (wordnum < 199800)
			return words27.words27[wordnum - 192400];
		if (wordnum < 207200)
			return words28.words28[wordnum - 199800];
		if (wordnum < 214600)
			return words29.words29[wordnum - 207200];
		if (wordnum < 222000)
			return words30.words30[wordnum - 214600];
		if (wordnum < 229400)
			return words31.words31[wordnum - 222000];
		if (wordnum < 236800)
			return words32.words32[wordnum - 229400];
		if (wordnum < 244200)
			return words33.words33[wordnum - 236800];
		if (wordnum < 251600)
			return words34.words34[wordnum - 244200];
		if (wordnum < 259000)
			return words35.words35[wordnum - 251600];
		if (wordnum < 266400)
			return words36.words36[wordnum - 259000];
		if (wordnum < 273800)
			return words37.words37[wordnum - 266400];
		if (wordnum < 281200)
			return words38.words38[wordnum - 273800];
		if (wordnum < 288600)
			return words39.words39[wordnum - 281200];
		if (wordnum < 296000)
			return words40.words40[wordnum - 288600];
		if (wordnum < 303400)
			return words41.words41[wordnum - 296000];
		if (wordnum < 310800)
			return words42.words42[wordnum - 303400];
		if (wordnum < 318200)
			return words43.words43[wordnum - 310800];
		if (wordnum < 325600)
			return words44.words44[wordnum - 318200];
		if (wordnum < 333000)
			return words45.words45[wordnum - 325600];
		if (wordnum < 340400)
			return words46.words46[wordnum - 333000];
		if (wordnum < 347800)
			return words47.words47[wordnum - 340400];
		if (wordnum < 355200)
			return words48.words48[wordnum - 347800];
		if (wordnum < 362600)
			return words49.words49[wordnum - 355200];
		if (wordnum < 370099)
			return words50.words50[wordnum - 362600];
		return "";
	}
}
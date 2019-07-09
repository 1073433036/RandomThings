package Metaprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CountRunTimes
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("src/MATHISNOTMETH/CountRunTimes.java"));
		ArrayList<String> file = new ArrayList<String>();
		while (f.ready())
			file.add(f.readLine());
		f.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/MATHISNOTMETH/CountRunTimes.java")));

		@SuppressWarnings("unused")
		int count = 6;
		for (String a : file)
		{
			if (a.length() > 14 && a.substring(0, 14).equals("		int count = "))
				out.println(a.substring(0, 14) + (Integer.parseInt(a.substring(14, a.length() - 1)) + 1) + ";");
			else
				out.println(a);

		}
		out.close();
		for (String s : file)
			System.out.println(s);
	}
}

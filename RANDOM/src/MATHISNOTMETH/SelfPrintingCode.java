package MATHISNOTMETH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelfPrintingCode
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("src/MATHISNOTMETH/SelfPrintingCode.java"));
		while (true)
		{
			String a = f.readLine();
			if (a == null)
				break;
			System.out.println(a);
		}
		f.close();
	}
}
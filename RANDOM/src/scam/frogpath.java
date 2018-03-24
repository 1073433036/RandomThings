package scam;

import java.util.Scanner;

public class frogpath
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		String path = scan.nextLine();

		System.out.println(writeAll(path));
		scan.close();
	}

	public static int writeAll(String path)
	{
		if (path.length() == 0)
			return 0;
		if (path.substring(0, 1).equals("#"))
			return 0;
		if (path.length() == 1)
			return 1;

		return writeAll(path.substring(1)) + writeAll(path.substring(2));
	}
}
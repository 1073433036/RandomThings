
package scam;

import java.util.Scanner;
import java.util.Stack;

public class dishes
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int dishes = scan.nextInt();
		int[] result = new int[dishes];
		int lstack = 0;
		int ndish = 1;
		Stack<Integer> dry = new Stack<>();
		while (lstack < dishes)
		{
			int com = scan.nextInt();
			int count = scan.nextInt();
			if (com == 1)
				for (int i = 0; i < count; i++)
				{
					dry.push(ndish);
					ndish++;
				}
			else
				for (int i = 0; i < count; i++)
				{
					result[lstack] = dry.pop();
					lstack++;
				}
		}
		for (int i = dishes - 1; i >= 0; i--)
			System.out.println(result[i]);
		scan.close();
	}
}

package scam;

import java.util.HashMap;
import java.util.Scanner;

public class longestIntersectionSubsequence
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String[] in1 = scan.next().split("");
		String[] in2 = scan.next().split("");
		HashMap<String, Integer> ineach1 = new HashMap<>();
		HashMap<String, Integer> ineach2 = new HashMap<>();
		HashMap<String, Integer> keys = new HashMap<>();
		for (int i = 0; i < in1.length; i++)
		{
			if (ineach1.containsKey(in1[i]))
				ineach1.put(in1[i], ineach1.get(in1[i]) + 1);
			ineach1.put(in1[i], 1);
			keys.put(in1[i], 1);
		}

		for (int i = 0; i < in2.length; i++)
		{
			if (ineach2.containsKey(in2[i]))
				ineach2.put(in2[i], ineach2.get(in2[i]) + 1);
			ineach2.put(in2[i], 1);
			keys.put(in2[i], 1);
		}

		int total = 0;
		for (String key : keys.keySet())
			if (ineach1.containsKey(key) && ineach2.containsKey(key))
				total += Math.min(ineach1.get(key), ineach2.get(key));

		System.out.println(total);

		scan.close();
	}
}

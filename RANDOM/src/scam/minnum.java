package scam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class minnum
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		scan.nextInt();
		int n = scan.nextInt();
		String[] digits = scan.next().split("");
		ArrayList<String> possible = find(digits);

		String[] nums = new String[n];
		for (int i = 0; i < n; i++)
			nums[i] = scan.next();

		ArrayList<String> result = solution(possible, nums);
		if (result.size() == 0)
			System.out.println("NO SOLUTION");
		else
		{
			Collections.sort(result);
			System.out.println(result.get(0));
		}

		scan.close();
	}

	public static ArrayList<String> solution(ArrayList<String> possible, String[] nums)
	{
		ArrayList<String> result = new ArrayList<>();
		for (String pass : possible)
			if (works(pass, nums))
				result.add(pass);
		return result;
	}

	public static boolean works(String pass, String[] nums)
	{
		if (pass.length() == 0)
			return true;
		
		for (String num : nums)
			if (pass.length() >= num.length() && pass.substring(0, num.length()).equals(num))
				if(works(pass.substring(num.length()), nums))
					return true;

		return false;
	}

	public static ArrayList<String> find(String[] digits)
	{
		ArrayList<String> result = new ArrayList<>();
		result.add("");
		for (int i = 0; i < digits.length; i++)
			if (digits[i].equals("?"))
			{
				int temp = result.size();
				for (int j = 0; j < temp; j++)
				{
					result.add(result.get(j) + 1);
					result.set(j, result.get(j) + 0);
				}
			}
			else
				for (int j = 0; j < result.size(); j++)
					result.set(j, result.get(j) + digits[i]);
		return result;
	}
}
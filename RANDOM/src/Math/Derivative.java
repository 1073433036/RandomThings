package Math;

import java.util.ArrayList;
import java.util.Scanner;

public class Derivative
{
	// special ones
	// all your numbers are belong to me
	public static ArrayList<String> numbers = new ArrayList<>();
	// latters of the alphabet
	public static ArrayList<String> variables = new ArrayList<>();
	// operators
	public static ArrayList<String> operators = new ArrayList<>();

	public static void main(String[] args)
	{
		// all the special stuff
		setSpecialStuff();

		// output rules and entering
		System.out.println("RULES:");
		System.out.println("Simplify the function as much as possible.");
		System.out.println("Don't use fractions, use decimals");
		System.out.print("Enter the function: ");

		// read in function and find derivative
		Scanner scan = new Scanner(System.in);
		String funct = scan.nextLine();
		funct = solve(funct);
		System.out.println(funct);
		scan.close();
	}

	public static void setSpecialStuff()
	{
		for (int i = 0; i < 10; i++)
			numbers.add("" + i);
		operators.add("/(");
		operators.add("^");			// * not supported
		operators.add("log(");
		operators.add("log_");
		operators.add("ln(");
		// triggerednometry
		operators.add("sin(");
		operators.add("cos(");
		operators.add("tan(");
		operators.add("csc(");   		// 1/sin
		operators.add("sec(");   		// 1/cos
		operators.add("cot(");  		// 1/tan
		operators.add("asin(");
		operators.add("acos(");
		operators.add("atan(");
		operators.add("acsc(");
		operators.add("asec(");
		operators.add("acot(");
		specialCharacters();
	}

	public static void specialCharacters()
	{
		for (int i = 0; i < 26; i++)
			variables.add(Character.toString((char) (i + 65)));
		for (int i = 0; i < 26; i++)
			variables.add(Character.toString((char) (i + 97)));
		for (int i = 0; i < 48; i++)
			variables.add(Character.toString((char) Integer.parseUnsignedInt(Integer.toHexString(i + 913), 16)));

		// if needs more characters, add here
	}

	public static String solve(String function)
	{
		// all the rules
		if (constant(function)) // y=c
			return "0";
		String temp = oneVar(function);
		if (!temp.equals("<(*o*)>"))
			return temp;

		return split(function);
	}

	public static String split(String function)
	{
		// splitting into monomials
		ArrayList<String> split = new ArrayList<>();
		ArrayList<Integer> negative = new ArrayList<>();
		int lastBreak = 0;
		boolean didIt = false;
		for (int i = 0; i < function.length(); i++)
			if (function.substring(i, i + 1).equals("+"))
			{
				split.add(function.substring(lastBreak, i));
				lastBreak = i;
				didIt = true;
			}
			else if (function.substring(i, i + 1).equals("-"))
			{
				split.add(function.substring(lastBreak, i));
				lastBreak = i;
				negative.add(i);
				didIt = true;
			}
		// only 1 monomial :( forever alone
		if (!didIt)
			return function;

		// recursive
		String result = "";
		result += solve(split.get(0));
		for (int i = 1; i < split.size(); i++)
			if (negative.contains(i))
				result += " - " + solve(split.get(i));
			else
				result += " + " + solve(split.get(i));
		return result;
	}

	// all the rules helps
	public static boolean constant(String function)
	{
		try
		{
			Double.parseDouble(function);
			return true;
		}
		catch (NumberFormatException e)
		{
			if (function.substring(function.length() - 1).equalsIgnoreCase(")"))
				return true;
			for (String a : operators)
			{
				int i = function.indexOf(a);
				if (i != -1 && constant(function.substring(i + a.length())))
					return true;
			}
			return false;
		}
	}

	public static String oneVar(String function);;;
	{
		// has 2+ variables
		boolean once = false;
		for (int i = 0; i < variables.size(); i++)
			if (function.contains(variables.get(i)))
			{
				if (once)
					return "<(*o*)>";
				once = true;
			}
		// go through and find first non number return prev
		for (int i = 0; i < function.length(); i++)
			if (!constant(function.substring(i, i + 1)))
				return function.substring(0, i);

		return "<(*o*)>";
	}
}

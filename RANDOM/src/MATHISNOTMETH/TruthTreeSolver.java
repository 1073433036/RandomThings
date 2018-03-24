package MATHISNOTMETH;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TruthTreeSolver
{
	public static int count = 0;
	public static int splitTimes = 0;
	public static ArrayList<String> repeats = new ArrayList<>();

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your statement:");
		String statement = scan.nextLine();
		System.out.println(solve(statement));
		scan.close();

		String statements;
		ArrayList<String> prop = new ArrayList<>();
		ArrayList<String> xs = new ArrayList<>();
		String width = "                                                                                                                            ";

		statements = TruthTreeSolver.solve(statement); // insert
														 // statement
		statements = reorder(statements);
		String[] split = statements.split("\n");
		System.out.println(statements);
		prop = new ArrayList<>();
		System.out.println(split.length);
		int x = width.length();
		for (int f = 0; f < split.length; f++)
		{
			if (split[f].equals(""))
				continue;
			if (repeats.contains(split[f]))
			{
				x /= 2;
				continue;
			}
			prop.add(split[f]);
			xs.add(width.substring(0, x));
		}
	}

	public static String solve(String statement)
	{
		String[] splitted = split(statement.substring(1));
		boolean truth = statement.substring(0, 1).equals("T");
		String solved = statement + "\n";

		if (splitted[0] == null)
			return "";

		// rules
		if (splitted[1].equals("^"))
			if (truth)
			{
				solved += "T" + splitted[0] + "\n";
				solved += "T" + splitted[2] + "\n";
				solved += solve("T" + splitted[0]) + "\n";
				solved += solve("T" + splitted[2]) + "\n";
				repeats.add("T" + splitted[0]);
				repeats.add("T" + splitted[2]);
			}
			else
			{
				solved += "F" + splitted[0] + "#\nF" + splitted[2] + "\n";
				solved += solve("F" + splitted[0]);
				solved += solve("F" + splitted[2]);
				splitTimes++;
				repeats.add("F" + splitted[0]);
				repeats.add("F" + splitted[2]);
			}

		else if (splitted[1].equals("v"))
			if (truth)
			{
				solved += "T" + splitted[0] + "#\nT" + splitted[2] + "\n";
				solved += solve("T" + splitted[0]);
				solved += solve("T" + splitted[2]);
				splitTimes++;
				repeats.add("T" + splitted[0]);
				repeats.add("T" + splitted[2]);
			}
			else
			{
				solved += "F" + splitted[0] + "\n";
				solved += "F" + splitted[2] + "\n";
				solved += solve("F" + splitted[0]);
				solved += solve("F" + splitted[2]);
				repeats.add("F" + splitted[0]);
				repeats.add("F" + splitted[2]);
			}

		else if (splitted[1].equals("->"))
			if (truth)
			{
				solved += "F" + splitted[0] + "#\nT" + splitted[2] + "\n";
				solved += solve("F" + splitted[0]);
				solved += solve("T" + splitted[2]);
				splitTimes++;
				repeats.add("F" + splitted[0]);
				repeats.add("T" + splitted[2]);
			}
			else
			{
				solved += "T" + splitted[0] + "\n";
				solved += "F" + splitted[2] + "\n";
				solved += solve("T" + splitted[0]);
				solved += solve("F" + splitted[2]);
				repeats.add("T" + splitted[0]);
				repeats.add("F" + splitted[2]);
			}

		else if (splitted[1].equals("~"))
			if (truth)
			{
				solved += "F" + splitted[0] + "\n";
				solved += solve("F" + splitted[0]);
				repeats.add("F" + splitted[0]);
			}
			else
			{
				solved += "T" + splitted[0] + "\n";
				solved += solve("T" + splitted[0]);
				repeats.add("T" + splitted[0]);
			}

		return solved;
	}

	public static String[] split(String statement)
	{
		String[] result = new String[3];
		if (statement.length() == 1)
			return result;
		if (statement.substring(0, 1).equals("("))
			statement = isInside(statement) ? statement.substring(1, statement.length() - 1) : statement;
		String[] statementSplit = statement.split("");
		Stack<String> paren = new Stack<>();

		for (int i = 0; i < statement.length(); i++)
		{
			if (statementSplit[i].equals("("))
			{
				paren.push(statementSplit[i]);
			}
			else if (statementSplit[i].equals(")"))
				paren.pop();
			if (paren.isEmpty() && i != 0)
			{
				if (statementSplit[0].equals("~"))
				{
					if (statementSplit[1].equals("("))
					{
						result[1] = "~";
						result[0] = statement.substring(2, statement.length() - 1);
						return result;
					}
					if (i + 1 == statement.length())
					{
						result[1] = "~";
						result[0] = statement.substring(1);
						return result;
					}
				}
				if (i == 1)
				{
					if (statement.substring(1, 2).equals("-"))
					{
						result[0] = statement.substring(0, i);
						result[1] = statement.substring(i, i + 2);
						result[2] = statement.substring(i + 2);
						return result;
					}
					result[0] = statement.substring(0, i);
					result[1] = statement.substring(i, i + 1);
					result[2] = statement.substring(i + 1);
					return result;
				}
				if (statement.substring(i + 1, i + 2).equals("-"))
				{
					result[0] = statement.substring(0, i + 1);
					result[1] = statement.substring(i + 1, i + 3);
					result[2] = statement.substring(i + 3);
					return result;
				}
				result[0] = statement.substring(0, i + 1);
				result[1] = statement.substring(i + 1, i + 2);
				result[2] = statement.substring(i + 2);
				return result;
			}
		}

		return result;
	}

	public static boolean isInside(String statement)
	{
		String test = statement.substring(1, statement.length() - 1);
		Stack<String> paren = new Stack<>();
		String[] splitted = test.split("");
		try
		{
			for (String a : splitted)
				if (a.equals("("))
					paren.push(a);
				else if (a.equals(")"))
					paren.pop();
		}
		catch (EmptyStackException e)
		{
			return false;
		}

		return true;
	}

	public static String reorder(String statements)
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> split = new ArrayList<String>();
		String[] s = statements.split("\n");
		for (String a : s)
			split.add(a);
		result.add(split.get(0));

		int times = 1;
		for (int i = 1; i < split.size(); i++)
			if (split.get(i).substring(split.get(i).length() - 1).equals("#"))
			{
				int c = 0;
				do
				{
					for (int j = 0; j < times; j++)
					{
						split.add(i, split.get(i + c));
						split.add(i, split.get(i + c));
					}
					c += 2;
					times *= 2;
				}
				while (split.get(c).substring(split.get(i).length() - 1).equals("#"));
			}

		String res = "";
		for (String a : result)
			res += a;
		return res;
	}
}

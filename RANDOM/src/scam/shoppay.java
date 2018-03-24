package scam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class shoppay
{
	private static int[] line = new int[1000];

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new BufferedReader(new FileReader(new File("shoppay.in"))));
		int reg = scan.nextInt();
		ArrayList<ArrayList<Integer>> registers = new ArrayList<>();
		for (int i = 0; i < reg; i++)
			registers.add(new ArrayList<Integer>());

		int head = 0;
		int tail = 0;
		do
		{
			boolean customer = scan.next().equals("C") ? true : false;
			int num = scan.nextInt();
			if (customer)
			{
				line[tail] = num;
				tail = (tail + 1) % 1000;
			}
			else
			{
				registers.get(num - 1).add(line[head]);
				head = (head + 1) % 1000;
			}
		}
		while (scan.hasNext() && !(head == tail));

		for (int i = 0; i < registers.size(); i++)
		{
			System.out.println(registers.get(i).size());
			for (int j = 0; j < registers.get(i).size(); j++)
				System.out.println(registers.get(i).get(j));
		}

		scan.close();
	}
}

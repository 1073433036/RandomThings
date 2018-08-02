package foobar;

public class lambdivision
{
	public static int answer(int total_lambs)
	{
		return fib(total_lambs) - exp(total_lambs);
	}

	public static int fib(int n)
	{
		int first = 1;
		int second = 1;
		if (n <= 2)
			return n;

		int total = 2;
		int count = 2;
		for (; total < n; count++)
		{
			int temp = first + second;
			first = second;
			second = temp;
			total += second;
		}

		if (total > n)
			return count - 1;

		return count;
	}

	public static int exp(int n)
	{
		int count = (int) (Math.log(n + 1) / Math.log(2));
		int last = (int) Math.pow(2, count - 1);
		int last2 = (int) Math.pow(2, count - 2);
		if (n - Math.pow(2, count) + 1 >= last + last2)
			return count + 1;
		return count;

	}

	public static void main(String[] args)
	{
		System.out.println(answer(13));
	}
}

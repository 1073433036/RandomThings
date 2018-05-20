package TRULYRANDOM;

// put tester in file into usaco not bin/src the
import java.io.IOException;
import java.util.HashMap;

public class ha
{
	public static void main(String[] args) throws IOException
	{
		int[] a =
			{ 6, 12, 3, 9, 3, 5, 1 };
		int k = 12;
		HashMap<Long, Boolean> usedNum = new HashMap<>();
		int two=0;
		for (int i = 0; i < a.length; i++)
		{
			if(a[i]*2==k)
				two++;
			usedNum.put((long) a[i], false);
		}
		if(two<2)
			usedNum.remove(k/2);

		int count = 0;
		for (Long b : usedNum.keySet())
		{
			if (!usedNum.get(b))
				if (usedNum.containsKey(k - b))
				{
					count++;
					usedNum.put(k - b, true);
					usedNum.put(b, true);
				}
		}

		System.out.println(count);
	}
}
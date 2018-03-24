import java.util.ArrayList;
import java.util.HashSet;

public class SandwichBar
{
	public int whichOrder(String[] available, String[] orders)
	{
		HashSet<String> hasIngredients = new HashSet<>();
		ArrayList<HashSet<String>> wantSandwich = new ArrayList<HashSet<String>>();

		for (String a : available)
			hasIngredients.add(a);
		for (String a : orders)
		{
			String[] sandwich = a.split(" ");
			HashSet<String> sandwichSet = new HashSet<>();
			for (String b : sandwich)
				sandwichSet.add(b);
			wantSandwich.add(sandwichSet);
		}

		int k = 0, l = 0;
		for (HashSet<String> s : wantSandwich)
		{
			for (String a : s)
			{
				if (!hasIngredients.contains(a))
					break;
				k++;
			}
			if (k == s.size())
				return l;
			l++;
			k = 0;
		}

		return -1;
	}
	// public static void main(String args[])
	// {
	// String[] a={"a", "a", "c", "b", "a", "b", "b" };
	// String[] b={"a b c d",
	// "d c b a", "c b a",
	// "a a a a b b b b b b b b b b",
	// "a a b b c", "a b c"};
	// System.out.println(whichOrder(a,b));
	// }
}

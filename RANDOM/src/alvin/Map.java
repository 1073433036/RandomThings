package alvin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class Map
{
	// count the number of times a char shows up
	// <'a':3>

	public static void main(String[] args)
	{
		HashMap<String, Integer> myMap = new HashMap<>();
		// myMap.put("a", 5);

		// int frequencyOfA = myMap.get("a");

		String sample = "aksjdflkajsdlkfjaskajksdfjklasdjfklwnekrjlsdfjalsdfnkasdfjlkasdjfkghasioquweoiqu";

		for (int i = 0; i < sample.length(); i++)
		{
			String c = String.valueOf(sample.charAt(i));
			if (!myMap.containsKey(c))
			{
				myMap.put(c, 1);
			}
			else
				myMap.put(c, myMap.get(c) + 1);
		}
		for (String name : myMap.keySet())
			System.out.println(name);
		myMap.containsValue(1);
		Hashtable<Integer, String> table = new Hashtable<>();
		// hashmap =no sort, lookup optimize
		// treemap=sort by key
		// linked hashmap=insert order
		// hashtable= synchronized/multiple threads

		for (String name : myMap.keySet())
		{

			String key = name.toString();
			String value = myMap.get(name).toString();
			System.out.println(key + " " + value);

		}

	}
}
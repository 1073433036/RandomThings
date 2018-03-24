import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

// for each country and ordering
class Country implements Comparable<Country>
{
	public int gold;
	public int silver;
	public int bronze;
	public String CCode;

	public Country(String cc, int g, int s, int b)
	{
		CCode = cc;
		gold = g;
		silver = s;
		bronze = b;
	}

	// gold, silver, bronze, country code
	public int compareTo(Country o)
	{
		if (gold > o.gold)
			return -1;
		if (gold < o.gold)
			return 1;
		if (silver > o.silver)
			return -1;
		if (silver < o.silver)
			return 1;
		if (bronze > o.bronze)
			return -1;
		if (bronze < o.bronze)
			return 1;
		return CCode.compareTo(o.CCode);
	}

	// output string[]
	public String toString()
	{
		return CCode + " " + gold + " " + silver + " " + bronze;
	}
}

// answer
public class MedalTable
{
	public String[] generate(String[] results)
	{
		// input results into countries
		HashMap<String, Country> countries = new HashMap<>();
		for (int i = 0; i < results.length; i++)
		{
			String[] temp = results[i].split(" ");

			// put gold bronze and silver into countries based on country
			Country gold = countries.get(temp[0]) == null ? new Country(temp[0], 0, 0, 0) : countries.get(temp[0]);
			countries.put(temp[0], new Country(temp[0], gold.gold + 1, gold.silver, gold.bronze));

			Country silver = countries.get(temp[1]) == null ? new Country(temp[1], 0, 0, 0) : countries.get(temp[1]);
			countries.put(temp[1], new Country(temp[1], silver.gold, silver.silver + 1, silver.bronze));

			Country bronze = countries.get(temp[2]) == null ? new Country(temp[2], 0, 0, 0) : countries.get(temp[2]);
			countries.put(temp[2], new Country(temp[2], bronze.gold, bronze.silver, bronze.bronze + 1));
		}

		// put countries into arraylist to sort
		ArrayList<Country> sortCountries = new ArrayList<>();
		for (Entry<String, Country> c : countries.entrySet())
			sortCountries.add(c.getValue());
		Collections.sort(sortCountries);

		// put sorted countries into String[]
		String[] medals = new String[sortCountries.size()];
		for (int i = 0; i < sortCountries.size(); i++)
			medals[i] = sortCountries.get(i).toString();

		return medals;
	}
}

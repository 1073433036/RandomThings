/*
 * while 2Repeat()
 * remove i and j from thesaurus
 * put hashset into string[]
 * sort string[]
 * put string[] into string
 * put string into thesaurus
 * 
 * 
 * 
 * 2Repeat():
 * for(thesauruslength)
 * for(thesauruslength)
 * take first entry
 * take second entry
 * hashset them in
 * if hashset size < first size +second size-1
 * set global var=i
 * set global var=j
 * set global hashset to hashset
 * return true
 * 
 * 
 * 
 * sort thesaurus
 * put thesaurus into string[]
 * return string[]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Thesaurus
{
	// init glob vars
	private static int i = 0;
	private static int j = 0;
	private static HashSet<String> ghash;

	public String[] edit(String[] entry)
	{
		ArrayList<String> thesaurus = new ArrayList<>();

		// initially sort entry so thesaurus will have sorted entries

		for (int m = 0; m < entry.length; m++)
		{
			String temp = "";
			String[] t = entry[m].split(" ");
			Arrays.sort(t);  //
			temp += t[0];
			for (int n = 1; n < t.length; n++)
				temp += " " + t[n];
			thesaurus.add(temp);
		}

		// get rid of repeats
		while (repeat(thesaurus))
		{
			thesaurus.remove(i);
			thesaurus.remove(j - 1); //

			// sort entry because might get mixed up
			String[] temp = new String[ghash.size()];
			int l = 0;
			for (String a : ghash)
			{
				temp[l] = a;
				l++;
			}
			Arrays.sort(temp);
			String a = temp[0];
			for (l = 1; l < temp.length; l++)
				a += " " + temp[l];
			thesaurus.add(i, a);
		}

		// sort whole thesaurus
		Collections.sort(thesaurus);

		// change from ArrayList to array
		String[] entries = new String[thesaurus.size()];
		for (int k = 0; k < thesaurus.size(); k++)
			entries[k] = thesaurus.get(k);

		return entries;
	}

	// check if there is repeats in thesaurus and sets global vars to place and
	// hashset
	public static boolean repeat(ArrayList<String> thesaurus)
	{
		for (int k = 0; k < thesaurus.size(); k++)
			for (int l = k + 1; l < thesaurus.size(); l++)
			{
				ghash = new HashSet<>();
				String[] a = thesaurus.get(k).split(" ");
				String[] b = thesaurus.get(l).split(" ");
				for (int m = 0; m < a.length; m++)
					ghash.add(a[m]);
				for (int m = 0; m < b.length; m++)
					ghash.add(b[m]);

				if (ghash.size() < a.length + b.length - 1)
				{
					i = k;
					j = l;
					return true;
				}
			}
		return false;
	}

	// public static void main(String[] args)
	// {
	// String[] b={"ape monkey wrench","wrench twist strain","monkey twist
	// frugue strain"};
	// String[] a=edit(b);
	// for(String c:a)
	// System.out.println(c);
	// }
}
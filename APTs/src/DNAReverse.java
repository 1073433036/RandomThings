// package randomthings;

public class DNAReverse
{
	public String reverse(String dna)
	{
		String a = "";
		for (int i = dna.length() - 1; i >= 0; i--)
		{
			a += dna.substring(i, i + 1);
		}
		return a;
	}
	// public static void main(String[] args)
	// {
	// System.out.println(reverse(""));
	// }
}

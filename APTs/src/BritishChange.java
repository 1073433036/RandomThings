
public class BritishChange
{
	public int[] coins(int pence)
	{
		// pence%240 == not pounds
		int notPound = pence % 240;
		// pence/240 == pounds
		int pounds = pence / 240;
		// (pence%240)/12 == shillings
		int shillings = notPound / 12;
		// (pence%240)%12 == pence
		int pences = notPound % 12;

		int[] ans =
			{ pounds, shillings, pences };
		return ans;
	}
	// public static void main(String[] args)
	// {
	// int[] coins=coins(10000);
	// for(int i=0;i<3;i++)
	// System.out.println(coins[i]);
	// }
}

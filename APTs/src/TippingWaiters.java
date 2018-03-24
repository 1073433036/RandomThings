
public class TippingWaiters
{
	public int possiblePayments(int bill, int cash)
	{
		// each time find solution, add 1
		// also since this is zero, if u has no enough money can just return
		int count = 0;

		// if bill is divis by 5 already startval is bill
		// otherwise bill is next multiple of 5
		int startingValue = bill % 5 == 0 ? bill : bill + (5 - (bill % 5));

		// go through each multiple of 5 between startingval and cash
		for (int i = startingValue; i < cash + 1; i += 5)
		{
			int tip = i - bill;

			// check if tip>=5%i and tip<=10%i
			if (tip >= .05 * i && tip <= .1 * i)
				count++;
		}
		return count;
	}
}

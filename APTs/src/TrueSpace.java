
public class TrueSpace
{
	public long calculateSpace(int[] sizes, int clusterSize)
	{
		// adds all the numbers
		long result = 0;

		// go through all sizes and add least multiple of clustersize to result
		for (int i = 0; i < sizes.length; i++)
		{
			int temp = sizes[i] % clusterSize;
			result += temp == 0 ? sizes[i] : sizes[i] - temp + clusterSize;
		}

		return result;
	}
}

// use distance formula to find if within circle
// basically count number of circles each point in but not in same ones

public class CirclesCountry
{
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2)
	{
		int circles = 0;

		// count how many circles around x1, y1 and x2, y2
		for (int i = 0; i < x.length; i++)
			// as long as both are not in same circle
			if (isInCircle(x[i], y[i], r[i], x1, y1) ^ isInCircle(x[i], y[i], r[i], x2, y2))
				circles++;

		return circles;
	}

	// distance formula
	public boolean isInCircle(int x, int y, int r, int x1, int y1)
	{
		return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2)) < r;
	}
}
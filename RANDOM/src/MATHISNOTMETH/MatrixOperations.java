package MATHISNOTMETH;

public class MatrixOperations
{
	public static double[][] multiply(double[][] m1, double[][] m2)
	{
		int m1Rows = m1.length;
		int m1Columns = m1[0].length;
		int m2Rows = m2.length;
		int m2Columns = m2[0].length;

		if (m1Columns != m2Rows)
		{
			throw new IllegalArgumentException("m1:Rows: " + m1Columns + " did not match m2:Columns " + m2Rows + ".");
		}

		double[][] C = new double[m2Rows][m2Columns];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				C[i][j] = 0.00000;

		for (int i = 0; i < m2Rows; i++)
			// aRow
			for (int j = 0; j < m2Columns; j++)
				// bColumn
				for (int k = 0; k < m1Columns; k++)
					// aColumn
					C[i][j] += m1[i][k] * m2[k][j];

		return C;

	}
}

package MATHISNOTMETH;

import java.util.Random;

public class NeuralNetworkTest
{
	public static double[][] synapticWeights;

	public static void main(String[] args)
	{
		// random number
		Random rand = new Random();
		// same each time ran
		rand.setSeed(1);

		// initialize weights
		for (int i = 0; i < 3; i++)
			synapticWeights[0][i] = 2 * rand.nextDouble() - 1;

		double[][] inputs =
			{
					{ 0, 0, 1 },
					{ 1, 1, 1 },
					{ 1, 0, 1 },
					{ 0, 1, 1 } };
		double[][] outputs =
			{
					{ 0 },
					{ 1 },
					{ 1 },
					{ 0 } };
		// train neural network
		train(inputs, outputs, 10000);

		for (int i = 0; i < synapticWeights[0].length; i++)
			System.out.println(synapticWeights[0][i]);

		// output result
		double[][] newInput =
			{
					{ 1, 0, 0 } };
		System.out.println(think(newInput));
	}

	// normalize sum inputs 0-1
	public static double sigmoid(double x)
	{
		return 1 / (1 + Math.pow(Math.E, x));
	}

	// confidence of existing weight
	public static double sigmoidGradient(double sigmoidOutput)
	{
		return sigmoidOutput * (1 - sigmoidOutput);
	}

	// trial and error
	public static void train(double[][] trainingInputs, double[][] trainingOutputs, int numIterations)
	{
		for (int i = 0; i < numIterations; i++)
		{
			double[][] output = think(trainingInputs);
		}
	}

	// thinking
	public static double[][] think(double[][] inputs)
	{
		double[][] thinking = new double[inputs.length][synapticWeights[0].length];
		for(int i=0;i<thinking.length;i++)
			for(int j=0;j<thinking.length;j++)
				for(int k=0;k<thinking.length;k++)
				{
					
				}
	}
}
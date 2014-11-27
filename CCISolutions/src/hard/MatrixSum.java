package hard;

public class MatrixSum
{
	static int[][] matrix = {
			{ 1, 2, -1, 3 },
			{ 2, -1, 4, -2 },
			{ 1, 2, 3, -1 },
			{ 1, 1, 4, -1 }
	};

	static class Matrix
	{
		int x, j, size;

		Matrix(int x, int j, int size)
		{
			this.x = x;
			this.j = j;
			this.size = size;
		}
	}

	// private int getSum(int i, int j, int size)
	// {
	// int sum = 0;
	// for (int row = i; row < Math.min(row + size - 1, matrix.length); row++)
	// {
	// for (int col = j; col < Math.min(col + size - 1, matrix.length); col++)
	// {
	// sum += matrix[row][col];
	// }
	// }
	//
	// return sum;
	// }
	// static int[][] subMatrix()
	// {
	// int maxSum = 0;
	// Matrix max = null;
	//
	// int currSum = 0;
	// for(int row = 0; row < Math.min(row + size - 1, matrix.length); row++)
	// {
	// for(int col = 0; col < Math.min(col + size - 1, matrix.length); col++)
	// {
	// currSum += matrix[row][col];
	// if(currSum > maxSum)
	// {
	// max = new Matrix(row, col, row ,
	// }
	// }
	// }
	//
	//
	// }

	private static int getMaxMatrix(int[][] matrix)
	{
		int max_sum = Integer.MIN_VALUE;

		int[][] sumMatrix = sumMatrix(matrix);

		for (int i1 = 0; i1 < matrix.length; i1++)
		{
			for (int j1 = 0; j1 < matrix.length; j1++)
			{
				for (int i2 = 0; i2 < matrix.length; i2++)
				{
					for (int j2 = 0; j2 < matrix.length; j2++)
					{
						max_sum = Math.max(max_sum, computeSum(sumMatrix, i1, j2, i2, j2));
					}
				}
			}
		}
		return max_sum;
	}

	private static int[][] sumMatrix(int[][] matrix)
	{
		int[][] sumMatrix = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
			{
				if (i == 0 && j == 0)
				{
					sumMatrix[i][j] = matrix[i][j];
				}
				else if (i == 0)
				{
					sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
				}
				else if (j == 0)
				{
					sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
				}
				else
				{
					sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];
				}
			}
		}

		return sumMatrix;
	}

	private static int computeSum(int[][] sumMatrix, int i1, int j1, int i2, int j2)
	{
		int sum;
		if (i1 == 0 && j1 == 0)
		{
			sum = sumMatrix[i2][j2];
		}
		else if (i1 == 0)
		{
			sum = sumMatrix[i2][j2] - sumMatrix[i1][j1 - 1];
		}
		else if (j1 == 0)
		{
			sum = sumMatrix[i2][j2] - sumMatrix[i1 - 1][j1];
		}
		else
		{
			sum = sumMatrix[i2][j2] - sumMatrix[i1][j1 - 1] - sumMatrix[i1 - 1][j1] + sumMatrix[i1 - 1][j1 - 1];
		}
		return sum;
	}

	public static void main(String[] args)
	{

	}
}
